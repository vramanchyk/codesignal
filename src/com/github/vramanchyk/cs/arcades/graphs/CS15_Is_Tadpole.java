package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS15_Is_Tadpole {

    boolean isTadpole(boolean[][] adj) {
        final int n = adj.length;

        int t2 = 0, t3 = 0, t1 = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    count++;
                }
            }

            if (count == 3) {
                t3++;
            } else if (count == 2) {
                t2++;
            } else if (count == 1) {
                t1++;
            } else {
                return false;
            }
        }

        return t3 == 1 && t2 == n - 2 && t1 == 1;
    }

}
