package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS16_Are_Similar {

    boolean areSimilar(int[] A, int[] B) {
        int offset = -1;
        int swaps = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                if (offset == -1) {
                    offset = i;
                } else {

                    if (A[offset] != B[i] || B[offset] != A[i]) {
                        return false;
                    }

                    swaps++;
                    offset = -1;
                }
            }
        }

        return swaps <= 1 && offset == -1;
    }
}
