package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class LongestDigitsPrefix {

    String longestDigitsPrefix(String str) {
        String result = "";
        for (char ch : str.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                result += ch;
            } else {
                break;
            }
        }

        return result;
    }

}
