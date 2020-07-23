package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class Minesweeper {

    int[][] minesweeper(boolean[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (i + x >= 0 && i + x < matrix.length &&
                                j + y >= 0 && j + y < matrix[0].length &&
                                matrix[i + x][j + y]) {

                            result[i][j]++;
                        }
                    }
                }
                if (matrix[i][j]) {
                    result[i][j]--;
                }
            }
        }

        return result;
    }

}
