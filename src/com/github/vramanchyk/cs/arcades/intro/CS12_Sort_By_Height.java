package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS12_Sort_By_Height {

    int[] sortByHeight(int[] a) {
        int[] result = new int[a.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                result[i] = -1;
                count++;
            }
        }

        Arrays.sort(a);
        int cursor = 0;

        for (int i = count; i < a.length; i++) {
            while (result[cursor] == -1) {
                cursor++;
            }
            result[cursor++] = a[i];
        }

        return result;
    }
}
