package com.local.coding_practice.Test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        char c1 = 'b';
        char c2 = 'c';
        sb.insert(0, c);
        sb.insert(0, c1);
        sb.insert(0, c2);
        System.out.println(sb.toString());
    }
}
