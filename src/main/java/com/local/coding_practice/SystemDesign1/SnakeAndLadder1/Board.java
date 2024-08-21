package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Integer, Move> cells;
    int cellCount;

    public Board(int dimension) {
        cells = new HashMap<>();
        cellCount = dimension * dimension;

        for (int i = 0; i < dimension; i++) {

            int min = 2;
            int max = cellCount - 1;
            int start = (int) Math.floor(Math.random() * (max - min + 1) + min);
            max = start - 1;
            int end = (int) Math.floor(Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(i)) {
                setEntity(i, new Snake(start, end));
            }

            max = cellCount - 1;
            end = (int) Math.floor(Math.random() * (max - min + 1) + min);
            max = end - 1;
            start = (int) Math.floor(Math.random() * (max - min + 1) + min);
            if (!hasSnakeOrLadder(i)) {
                setEntity(i, new Ladder(start, end));
            }
        }
    }

    public Move getEntity(int start) {
        return this.cells.get(start);
    }

    public void setEntity(int start, Move move) {
        this.cells.put(start, move);
    }

    public boolean hasSnakeOrLadder(int start) {
        return cells.containsKey(start);
    }

    public void printBoard() {
        for (int i = cellCount - 1; i > 0; i--) {
            System.out.print(i + " ");
            if (hasSnakeOrLadder(i)) {
                System.out.print(cells.get(i).getString());
            } else {
                System.out.print("  ");
            }

            if (i % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
