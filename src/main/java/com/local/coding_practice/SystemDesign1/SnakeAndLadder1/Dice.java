package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

public class Dice {

    public static int roll(int diceCount) {
        int min = 1;
        int max = diceCount * 6;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
