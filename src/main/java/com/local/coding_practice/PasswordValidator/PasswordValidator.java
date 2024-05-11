package com.local.coding_practice.PasswordValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        boolean isVlid = false;
        try {
            isVlid = validatePassword(password);
        } catch (InvalidPasswordException ex) {
            ex.getMessage();
            System.out.println(ex.printMessage());
        }

        if(isVlid){
            System.out.println("Password is Valid!!");
        }
    }

    private static boolean validatePassword(String password) throws InvalidPasswordException {

        if (password.length() < 8 || password.length() > 15) {
            throw new InvalidPasswordException(1);
        }

        if (password.contains(" ")) {
            throw new InvalidPasswordException(2);
        }

        if (true) {
            int count = 0;

            for (int i = 0; i <= 9; i++) {
                String str = Integer.toString(i);
                if (password.contains(str)) {
                    count += 1;
                }
            }

            if (count == 0) {
                throw new InvalidPasswordException(3);
            }
        }

        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            throw new InvalidPasswordException(4);
        }

        if (true) {
            int count = 0;
            for (int i = 65; i <= 90; i++) {
                char ch = (char) i;
                String str1 = Character.toString(ch);
                if (password.contains(str1)) {
                    count += 1;
                }
            }

            if (count == 0) {
                throw new InvalidPasswordException(5);
            }
        }

        if (true) {
            int count = 0;
            for (int i = 97; i <= 122; i++) {
                char ch = (char) i;
                String str = Character.toString(ch);
                if (password.contains(str)) {
                    count += 1;
                }
            }

            if (count == 0) {
                throw new InvalidPasswordException(6);
            }
        }
        return true;
    }


}
