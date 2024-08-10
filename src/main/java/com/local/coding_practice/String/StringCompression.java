package com.local.coding_practice.String;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {

    public static void main(String[] args) {
        char[] arr = {'a','a','b','b','c','c','c'};
        int ans = compress(arr);
        System.out.println(ans);
    }

    public static int compress(char[] chars) {

        if(chars.length == 1){
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : chars){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            sb.append(entry.getKey());
            chars[k++] = entry.getKey();
            sb.append(entry.getValue());
            int i = entry.getValue();
            chars[k++] = (char)i;
        }

        return sb.toString().length();

    }
}
