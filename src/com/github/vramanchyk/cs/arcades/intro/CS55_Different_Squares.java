package com.github.vramanchyk.cs.arcades.intro;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS55_Different_Squares {

    int differentSquares(int[][] matrix) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                set.add(matrix[i][j] * 1000 + matrix[i + 1][j] * 100 + matrix[i][j + 1] * 10 + matrix[i + 1][j + 1]);
            }
        }

        return set.size();
    }

}
