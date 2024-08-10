package com.local.coding_practice.SystemDesign.SnakeAndLadder;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Getter
@Setter
public class Game {
    Board board;
    Queue<Player> players;
    Queue<Player> winners;
    int diceCount;
    int dimension;
    int size;


    public Game(int dimension, int diceCount) {
        this.size = dimension * dimension;
        this.diceCount = diceCount;
        board = new Board(dimension);
        players = new LinkedList<>();
        winners = new LinkedList<>();
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
            printPosition();
        }
    }

    private void printPosition() {
        for (Player player : players) {
            System.out.println(player.getUserName() + ":" + player.getPosition());
        }
    }

    private void makeMove(Player currentPlayer) {
        int currenPosition = currentPlayer.getPosition();
        int move = Dice.roll(this.diceCount);
        System.out.println("You got: " + move);
        int finalPosition = currenPosition + move;
        if (finalPosition <= size) {
            if (board.hasSnakeOrLadder(finalPosition)) {
                System.out.println(board.getEnity(finalPosition).getEncounterMessage());
                finalPosition = board.getEnity(finalPosition).getEndPosition();
            }
            System.out.println("Taking you to: " + finalPosition);
        } else {
            System.out.println("Try again in next turn");
            finalPosition = currenPosition;
        }
        currentPlayer.setPosition(finalPosition);
    }

    public void addPlayer(String userName) {
        players.add(new Player(userName));
    }
}