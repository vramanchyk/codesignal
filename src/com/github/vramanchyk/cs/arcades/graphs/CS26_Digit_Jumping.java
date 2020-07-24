package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS26_Digit_Jumping {

    private static class Pair {

        final int x, y, step;

        Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int digitJumping(int[][] grid, int[] start, int[] finish) {
        int n = grid.length;
        int m = grid[0].length;

        if (start[0] == finish[0] && start[1] == finish[1]) {
            return 0;
        }

        int[][][] matrix = new int[10][n * m + 4][2];
        int[] size = new int[10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int digit = grid[i][j];
                matrix[digit][size[digit]][0] = i;
                matrix[digit][size[digit]++][1] = j;
            }
        }

        boolean[][] was = new boolean[n][m];

        final Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(start[0], start[1], 0));
        was[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int digit = grid[pair.x][pair.y];
            for (int index = 0; index < size[digit]; index++) {
                int xx = matrix[digit][index][0];
                int yy = matrix[digit][index][1];

                if (!was[xx][yy]) {
                    if (finish[0] == xx && finish[1] == yy) {
                        return pair.step + 1;
                    }

                    was[xx][yy] = true;
                    queue.add(new Pair(xx, yy, pair.step + 1));
                }
            }

            for (int[] d : dir) {
                int xx = pair.x + d[0];
                int yy = pair.y + d[1];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (!was[xx][yy]) {
                        if (finish[0] == xx && finish[1] == yy) {
                            return pair.step + 1;
                        }

                        was[xx][yy] = true;
                        queue.add(new Pair(xx, yy, pair.step + 1));
                    }
                }
            }
        }

        return -1;
    }
}
