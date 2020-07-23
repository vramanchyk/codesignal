package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS14_Is_Bull {

    boolean isBull(boolean[][] adj) {
        int cycles = 0;
        int vertex = 0;

        for (int i = 0; i < 5; i++) {

            if (adj[i][i]) {
                return false;
            }

            for (int j = i + 1; j < 5; j++) {
                if (adj[i][j]) {
                    for (int k = j + 1; k < 5; k++) {
                        if (adj[i][k] && adj[j][k]) {
                            cycles++;
                        }
                    }
                    if (j > i) {
                        vertex++;
                    }
                }
            }
        }

        return cycles == 1 && vertex == 5;
    }

}
