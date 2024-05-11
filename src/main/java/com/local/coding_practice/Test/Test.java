package com.local.coding_practice.Test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map<Character, Integer> map= new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 1);
        map.put('d', 1);

        for(Character ch : map.keySet()){
            System.out.println(ch);
        }
    }

}
