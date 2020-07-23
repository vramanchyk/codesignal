package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS13_Is_Book {

    boolean isBook(boolean[][] adj) {
        final int n = adj.length;

        int A = -1, B = -1;

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
                if (A < 0) {
                    A = i;
                } else if (B < 0) {
                    B = i;
                }
            }
        }

        if (A < 0 || B < 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (i == A || i == B) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    if (j != A && j != B) {
                        return false;
                    }
                    count++;
                }
            }
            if (count != 2) {
                return false;
            }
        }

        return true;
    }
}
