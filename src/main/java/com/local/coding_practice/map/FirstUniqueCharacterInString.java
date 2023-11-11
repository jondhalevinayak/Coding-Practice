package com.local.coding_practice.map;

import java.util.*;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
