package com.local.coding_practice.misc;

import java.util.ArrayList;
import java.util.List;

public class PascleTriangle {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for(List<Integer> list : generate){
            for(int i : list){
                System.out.print(i + " ");
            }
        }
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        } else {
            while (numRows > 0) {
                result.add(addPascleRow(numRows - 1));
                numRows--;
            }
        }

        return result;
    }

    static List<Integer> addPascleRow(int numRows) {
        List<Integer> row = new ArrayList<>();
        if (numRows == 0) {
            row.add(1);
            return row;
        } else {
            row.add(1);

            List<Integer> prevRow = addPascleRow(numRows - 1);
            for (int i = 1; i < numRows; i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            row.add(1);
            return row;
        }
    }

}

