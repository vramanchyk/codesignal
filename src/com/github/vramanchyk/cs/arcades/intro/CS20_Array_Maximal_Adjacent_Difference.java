package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS20_Array_Maximal_Adjacent_Difference {

    int arrayMaximalAdjacentDifference(int[] array) {
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            result = Math.max(result, Math.abs(array[i - 1] - array[i]));
        }

        return result;
    }

}
