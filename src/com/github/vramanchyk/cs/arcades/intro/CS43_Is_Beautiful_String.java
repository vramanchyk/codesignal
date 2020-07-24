package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS43_Is_Beautiful_String {

    boolean isBeautifulString(String str) {
        int[] counts = new int[26];
        str.chars().forEach(c -> counts[c - 'a']++);

        for (int i = 1; i < 26; i++) {
            if (counts[i] > counts[i - 1]) {
                return false;
            }
        }

        return true;
    }

}
