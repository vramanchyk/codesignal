package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS06_Great_Renaming {

    boolean[][] greatRenaming(boolean[][] roadRegister) {
        final int n = roadRegister.length;
        boolean[][] result = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[(i + 1) % n][(j + 1) % n] = roadRegister[i][j];
            }
        }

        return result;
    }

}
