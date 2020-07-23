package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class AlmostIncreasingSequence {

    boolean almostIncreasingSequence(int[] seq) {

        int[] state = new int[3];

        for (int index = 1; index < seq.length; index++) {
            if (seq[index] > seq[index - 1]) {
                state[2] = state[1];
            } else {
                if (index > 1) {
                    if (seq[index] <= seq[index - 2]) {
                        state[2] = state[0] + 1;
                    }
                } else {
                    state[2] = state[1];
                }
            }

            state[0] = state[1];
            state[1] = state[2];
            state[2] = 0;
        }

        return state[1] < 2;
    }
}
