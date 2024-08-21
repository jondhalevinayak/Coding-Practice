package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

public class Snake extends Move {
    public Snake(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    @Override
    public String getEncounterMessage() {
        return "Oopps you encounter snake!!";
    }

    @Override
    public String getString() {
        return "S(" + this.endPosition + ")";
    }
}
