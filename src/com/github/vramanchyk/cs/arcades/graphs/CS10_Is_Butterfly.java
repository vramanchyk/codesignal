package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS10_Is_Butterfly {

    boolean isButterfly(boolean[][] adj) {
        final int n = adj.length;

        int p4 = 0, p2 = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    cnt++;
                }
            }
            if (cnt == 4) p4++;
            if (cnt == 2) p2++;
            if (adj[i][i]) {
                return false;
            }
        }

        return p4 == 1 && p2 == n - 1;
    }

}
