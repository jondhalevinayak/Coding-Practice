package com.local.coding_practice.Test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int k =  2 % 5;
        System.out.println(k);

        Arrays.asList(0, 1);
        var a = 1;


    }

    private static boolean validParathesis(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(Map.Entry<Character, Character> entry : map.entrySet()){

        }
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch)){
                stack.add(ch);
            } else if(!stack.isEmpty() && (map.get(stack.peek()) == ch)){
                stack.pop();
            } else{
                return false;
            }

        }

        return stack.isEmpty();
    }


}
