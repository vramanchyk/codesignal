package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class StringsRearrangement {

    boolean result = false;

    boolean fit(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    void solve(String[] a, String last, int state) {
        if (state == 0) {
            result = true;
        }

        if (result) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (((state >> i) & 1) == 1 && fit(last, a[i])) {
                solve(a, a[i], state ^ (1 << i));
            }
        }
    }

    boolean stringsRearrangement(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (result) {
                break;
            }

            solve(inputArray, inputArray[i], (1 << inputArray.length) - 1);
        }
        return result;
    }

}
