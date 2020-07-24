package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS14_Alternating_Sums {

    int[] alternatingSums(int[] a) {
        int[] result = new int[2];

        for (int i = 0; i < a.length; i++) {
            result[i % 2] += a[i];
        }

        return result;
    }
}
