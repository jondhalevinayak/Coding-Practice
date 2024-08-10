package com.local.coding_practice.String;

public class WildcardMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {

        int j = 0;
        int i = 0;
        boolean[] dp = new boolean[s.length()];

        for (i = 0; i < s.length(); i++) {
            if (j < p.length() && s.charAt(i) == p.charAt(j)) {
                dp[i] = true;

                j++;

            } else if (p.charAt(j) == '?') {
                dp[i] = true;

                j++;

            } else if (p.charAt(j) == '*') {
                dp[i] = true;

            }
        }

        for (boolean b : dp) {
            if (b == false) {
                return false;
            }

        }


        return true;
    }
}
