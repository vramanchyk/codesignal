package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS16_Is_Flower {

    private boolean[] visited;

    private boolean[][] a;

    private int n;

    void solve(int t) {
        visited[t] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[t][i]) {
                solve(i);
            }
        }
    }

    boolean isFlower(boolean[][] adj) {

        n = adj.length;
        visited = new boolean[n];
        a = adj;

        int center = -1;
        int max = -1;
        int min = -1;
        int ver = 0;

        for (int i = 0; i < n; i++) {
            if (adj[i][i]) return false;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    count++;
                    ver++;
                }
            }
            if (count == 0) {
                return false;
            }
            if (count > max) {
                max = count;
                center = i;
            }
            if (min < 0 || count < min) {
                min = count;
            }
        }

        if (max < 0 || min < 0) {
            return false;
        }

        if (max % min != 0) {
            return false;
        }

        if (max == min) {
            return ver == (n * (n - 1));
        }

        int petals = max / min;
        if (ver != petals * min * (min + 1)) {
            return false;
        }

        if (n != petals * min + 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (i == center) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    count++;
                }
            }
            if (count != min) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            adj[i][center] = adj[center][i] = false;
        }

        int parts = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                solve(i);
                parts++;
            }
        }

        return parts == petals + 1;
    }
}
