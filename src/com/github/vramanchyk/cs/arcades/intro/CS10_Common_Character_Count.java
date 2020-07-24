package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS10_Common_Character_Count {

    int commonCharacterCount(String s1, String s2) {
        int[] c1 = new int[26], c2 = new int[26];
        s1.chars().forEach(c -> c1[c - 'a']++);
        s2.chars().forEach(c -> c2[c - 'a']++);

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.min(c1[i], c2[i]);
        }

        return count;
    }
}
