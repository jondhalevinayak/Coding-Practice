package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

public class Ladder extends Move {
    public Ladder(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    @Override
    public String getEncounterMessage() {
        return "Woohoo you got Ladder!!";
    }

    @Override
    public String getString() {
        return "L(" + this.endPosition + ")";
    }
}
