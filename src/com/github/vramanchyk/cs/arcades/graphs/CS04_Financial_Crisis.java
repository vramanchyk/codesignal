package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS04_Financial_Crisis {

    boolean[][][] financialCrisis(boolean[][] roadRegister) {
        int n = roadRegister.length;
        boolean[][][] result = new boolean[n][n - 1][n - 1];

        for (int q = 0; q < n; q++) {
            int row = 0, col = 0;

            for (int i = 0; i < n; i++) {
                if (i == q) continue;

                col = 0;

                for (int j = 0; j < n; j++) {
                    if (j == q) continue;
                    result[q][row][col] = roadRegister[i][j];
                    col++;
                }

                row++;
            }
        }

        return result;
    }

}
