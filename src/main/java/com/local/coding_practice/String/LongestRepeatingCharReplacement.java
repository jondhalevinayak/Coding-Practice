package com.local.coding_practice.String;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        int ans = characterReplacement("AABAABB", 2);
        System.out.print(ans);
    }

    static int characterReplacement(String S, int K) {
        // code here
        int start = 0;
        int end = 0;
        int maxAns = 0;
        int maxFreq = 0;
        char[] count = new char[26];

        while (end < S.length()) {
            count[S.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, count[S.charAt(end) - 'A']);

            while ((end - start + 1) - maxFreq > K) {
                count[S.charAt(start) - 'A']--;
                start++;
            }
            maxAns = Math.max(maxAns, end - start + 1);
            end++;
        }
        return maxAns;
    }


}
