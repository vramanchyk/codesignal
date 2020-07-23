package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS12_Is_Wheel {

    boolean isWheel(boolean[][] adj) {
        final int n = adj.length;

        int center = 0, side = 0;

        for (int i = 0; i < n; i++) {

            if (adj[i][i]) {
                return false;
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    count++;
                }
            }

            if (count == n - 1) {
                center++;
            }

            if (count == 3) {
                side++;
            }
        }

        return (n == 4 && side == n) || (center == 1 && side == n - 1);
    }

}
