package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ArrayMaxConsecutiveSum {

    int arrayMaxConsecutiveSum(int[] array, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        int maxSum = sum;

        for (int i = k; i < array.length; i++) {
            sum += array[i] - array[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

}
