package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS60_Sudoku {

    static final int TARGET = 511;

    boolean sudoku(int[][] grid) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] sqrs = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = 1 << (grid[i][j] - 1);
                rows[i] |= value;
                cols[j] |= value;
                sqrs[(i / 3) * 3 + (j / 3)] |= value;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (rows[i] != TARGET || cols[i] != TARGET || sqrs[i] != TARGET) {
                return false;
            }
        }

        return true;
    }

}
