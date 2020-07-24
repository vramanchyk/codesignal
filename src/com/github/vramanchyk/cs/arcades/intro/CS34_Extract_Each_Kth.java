package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS34_Extract_Each_Kth {

    int[] extractEachKth(int[] inputArray, int k) {
        int len = inputArray.length - inputArray.length / k;
        int[] result = new int[len];
        int position = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k != 0) {
                result[position++] = inputArray[i];
            }
        }

        return result;
    }

}
