package com.local.coding_practice.Test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String str1 = "{(}{(((}{{}}}]][]";
        String str2 = "{}()[]";

        boolean val = validParathesis(str1);
        System.out.println(val);

        boolean val2 = validParathesis(str2);
        System.out.println(val2);

    }

    private static boolean validParathesis(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

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
