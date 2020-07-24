package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS28_Horsebot {

    private static class Pair {

        final int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] DIR = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    final Queue<Pair> queue = new ArrayDeque<>();

    boolean canMove(int n, int m, int a, int b, int step, int[][] mark) {
        queue.clear();
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.x == n - 1 && pair.y == m - 1) {
                return true;
            }
            for (int[] dir : DIR) {
                int xx = pair.x + dir[0] * a;
                int yy = pair.y + dir[1] * b;
                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (mark[xx][yy] < step) {
                        mark[xx][yy] = step;
                        queue.add(new Pair(xx, yy));
                    }
                }

                xx = pair.x + dir[0] * b;
                yy = pair.y + dir[1] * a;
                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (mark[xx][yy] < step) {
                        mark[xx][yy] = step;
                        queue.add(new Pair(xx, yy));
                    }
                }
            }
        }

        return false;
    }

    int horsebot(int n, int m) {
        int[][] mark = new int[n][m];

        int step = 1;
        int ans = 0;

        int limit = Math.max(n, m);

        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                if (canMove(n, m, a, b, step, mark)) {
                    ans++;
                }
                step++;
            }
        }

        return ans;
    }
}
