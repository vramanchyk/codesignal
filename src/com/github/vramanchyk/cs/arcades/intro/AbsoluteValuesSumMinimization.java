package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class AbsoluteValuesSumMinimization {

    int sum(int[] a, int x) {
        int sum = 0;
        for (int value : a) {
            sum += Math.abs(value - x);
        }
        return sum;
    }

    int absoluteValuesSumMinimization(int[] A) {
        int bestSum = Integer.MAX_VALUE, solution = -1;

        for (int x : A) {
            final int sum = sum(A, x);
            if (sum < bestSum) {
                bestSum = sum;
                solution = x;
            }
        }

        return solution;
    }
}
