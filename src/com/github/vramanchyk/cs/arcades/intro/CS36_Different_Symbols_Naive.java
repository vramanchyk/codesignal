package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS36_Different_Symbols_Naive {

    int differentSymbolsNaive(String s) {
        char[] chars = s.toCharArray();

        Arrays.sort(chars);
        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i - 1] != chars[i]) {
                ans++;
            }
        }

        return ans;
    }

}
