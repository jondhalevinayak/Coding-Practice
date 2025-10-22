package com.local.coding_practice.Enum;

public class EnumEx {

    public static void main(String[] args) {
        for (Direction direction : Direction.values()) {
            System.out.println(direction+ " : " + direction.getDir());
        }
    }

}
