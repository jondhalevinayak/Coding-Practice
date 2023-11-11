package com.local.coding_practice.map;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] arr = {"test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"};
        int result = numUniqueEmails(arr);
        System.out.println(result);
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String email : emails){
            int len = email.length();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < len; i++){
                char ch = email.charAt(i);
                if(ch == '.'){
                    continue;
                } else if(ch == '+' || ch == '@'){
                    while(i < len && email.charAt(i) != '@'){
                        i++;
                    }
                    sb.append(email, i, len);
                } else {
                    sb.append(ch);
                }
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
