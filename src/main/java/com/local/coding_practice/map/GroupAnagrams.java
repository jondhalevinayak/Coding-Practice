package com.local.coding_practice.map;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(result);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedKey = sort(str);
            if (map.containsKey(sortedKey)) {
                map.get(sortedKey).add(str);
            } else {
                map.put(sortedKey, new ArrayList<>(Arrays.asList(str)));
            }
        }

        List<List<String>> result = new ArrayList<>();
        map.forEach((k, v) -> result.add(v));
        return result;
    }

    public static String sort(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
