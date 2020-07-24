package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS08_Matrix_Elements_Sum {

    int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        boolean[] was = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    was[j] = true;
                }

                if (!was[j]) sum += matrix[i][j];
            }
        }

        return sum;
    }
}
