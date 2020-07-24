package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS45_Build_Palindrome {

    boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    String buildPalindrome(String str) {
        String suffix = "";
        int index = 0;

        while (index < str.length()) {
            if (isPalindrome(str + suffix)) {
                return str + suffix;
            }

            suffix = str.charAt(index++) + suffix;
        }

        return str + suffix;
    }

}
