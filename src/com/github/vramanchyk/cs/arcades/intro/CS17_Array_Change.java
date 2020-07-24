package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS17_Array_Change {

    int arrayChange(int[] inputArray) {
        int moves = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[i - 1]) {
                moves += inputArray[i - 1] - inputArray[i] + 1;
                inputArray[i] = inputArray[i - 1] + 1;
            }
        }

        return moves;
    }
}
