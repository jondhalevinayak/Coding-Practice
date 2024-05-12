package com.local.coding_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Base62Encode {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Long counter = 1L;
        Map<String, Long> urlToIndex = new HashMap<>();
        if (urlToIndex.containsKey(str)) {
            Long longId = urlToIndex.get(str);
        } else {
            urlToIndex.put(str, counter);
            counter += 1;
        }

        String base62Str = base62Encode(urlToIndex.get(str));
        System.out.println(base62Str);

    }

    private static String base62Encode(long val) {
        String base62Str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        while (val != 0) {
            sb.append(base62Str.charAt((int) (val % 62)));
            val /= 62;
        }

        if(sb.length() < 7) {
            while (sb.length() < 7) {
                sb.append(0);
            }
        } else {
            sb.substring(0, 8);
        }

        return new String(sb);
    }

}
