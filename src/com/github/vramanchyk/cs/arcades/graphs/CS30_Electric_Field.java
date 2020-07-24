package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS30_Electric_Field {

    private static class Pair {

        final int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] DIR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    void setupSegments(int[][] matrix, int[][] wires) {
        for (int[] s : wires) {
            if (s[0] == s[2]) {
                int l = Math.min(s[1], s[3]);
                int r = Math.max(s[1], s[3]);
                for (int i = l; i < r; i++) {
                    if (s[0] - 1 >= 0) {
                        matrix[i][s[0] - 1] |= (1 << 1);
                    }
                    matrix[i][s[0]] |= 1;
                }
            } else {
                int t = Math.min(s[0], s[2]);
                int b = Math.max(s[0], s[2]);
                for (int j = t; j < b; j++) {
                    if (s[1] - 1 >= 0) {
                        matrix[s[1] - 1][j] |= (1 << 3);
                    }
                    matrix[s[1]][j] |= (1 << 2);
                }
            }
        }
    }

    void solve(int n, int m, int[][] matrix, int[][] step) {
        final Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0));
        step[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < DIR.length; i++) {
                int xx = pair.x + DIR[i][0];
                int yy = pair.y + DIR[i][1];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (step[xx][yy] == 0 && (((matrix[pair.x][pair.y] >> i) & 1) == 0)) {
                        step[xx][yy] = step[pair.x][pair.y] + 1;
                        queue.add(new Pair(xx, yy));
                    }
                }
            }
        }
    }

    int electricField(int[] grid, int[][] wires) {
        int n = grid[0];
        int m = grid[1];
        int[][] matrix = new int[n + 1][m + 1];
        int[][] step = new int[n][m];

        setupSegments(matrix, wires);
        solve(n, m, matrix, step);

        return step[n - 1][m - 1] == 0 ? -1 : step[n - 1][m - 1] - 1;
    }
}
