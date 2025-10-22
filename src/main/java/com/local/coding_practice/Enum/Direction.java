package com.local.coding_practice.Enum;

public enum Direction {
    NORTH("Up"),
    SOUTH("Down"),
    EAST("Right"),
    WEST("Left");

    private final String dir;

    Direction(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
}
