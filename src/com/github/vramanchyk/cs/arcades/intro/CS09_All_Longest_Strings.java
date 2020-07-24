package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS09_All_Longest_Strings {

    String[] allLongestStrings(String[] inputArray) {
        int maxLen = Arrays.stream(inputArray).mapToInt(String::length).max().orElse(0);
        return Arrays.stream(inputArray).filter(s -> s.length() == maxLen).toArray(String[]::new);
    }
}
