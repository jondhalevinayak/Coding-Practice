package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

import com.local.coding_practice.SystemDesign.SnakeAndLadder.Dice;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.local.coding_practice.SystemDesign1.SnakeAndLadder1.Board;

@Getter
@Setter
public class Game {

    Queue<Player> players;
    Queue<Player> winners;
    int size;
    int dimension;
    int diceCount;
    com.local.coding_practice.SystemDesign1.SnakeAndLadder1.Board board;

    public Game(int dimension, int diceCount) {
        this.diceCount = diceCount;
        this.dimension = dimension;
        players = new LinkedList<>();
        winners = new LinkedList<>();
        this.size = dimension * dimension;
        board = new Board(dimension);
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }

    public void launchGame() {
        this.board.printBoard();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            System.out.println();
            System.out.println("Turn to play: " + currentPlayer.getUserName());
            System.out.println("Press 'r' to roll the dice");
            Scanner scn = new Scanner(System.in);
            char c = scn.next().charAt(0);
            makeMove(currentPlayer);
            if (currentPlayer.getPosition() == size) {
                System.out.println(currentPlayer.getUserName() + " Won!!");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }

        printPosition();

    }

    private void makeMove(Player currentPlayer) {
        int currenPosition = currentPlayer.getPosition();
        int move = Dice.roll(this.diceCount);
        System.out.println("You got: " + move);
        int finalPosition = currenPosition + move;

        if (finalPosition <= size) {
            if (board.hasSnakeOrLadder(finalPosition)) {
                System.out.println(this.board.getEnity(finalPosition).getEncounterMessage());
                finalPosition = this.board.getEnity(finalPosition).getEndPosition();
            }
        } else {
            System.out.println("Try again in next turn");
            finalPosition = currenPosition;
        }

        currentPlayer.setPosition(finalPosition);

    }

    private void printPosition() {
        for (Player player : players) {
            System.out.println(player.getUserName() + ":" + player.getPosition());
        }
    }

}
