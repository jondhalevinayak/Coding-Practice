package com.local.coding_practice.SystemDesign.SnakeAndLadder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Move {

    private int startPosition;
    private int endPosition;


    public Move(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public abstract String getEncounterMessage();

    public abstract String getString();

}
