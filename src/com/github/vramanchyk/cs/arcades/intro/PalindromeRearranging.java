package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class PalindromeRearranging {

    boolean palindromeRearranging(String str) {
        int[] counts = new int[26];
        str.chars().forEach(c -> counts[c - 'a']++);

        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                odd++;
            }
        }

        return odd < 2;
    }
}
