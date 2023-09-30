package com.local.coding_practice.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "{{}}()[]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            } else if(map.containsValue(c)){
                if(!stack.empty() && map.get(stack.peek()) == c){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
