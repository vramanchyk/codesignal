package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS29_Sabotage {

    final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    final char[] LETTER = {'L', 'R', 'U', 'D'};

    private static class Pair {

        final int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int sabotage(char[][] hangar) {
        final Queue<Pair> queue = new ArrayDeque<>();
        final int n = hangar.length, m = hangar[0].length;
        final boolean[][] mark = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if (hangar[0][j] == 'U') {
                queue.add(new Pair(0, j));
                mark[0][j] = true;
            }
            if (hangar[n - 1][j] == 'D') {
                queue.add(new Pair(n - 1, j));
                mark[n - 1][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (hangar[i][0] == 'L') {
                queue.add(new Pair(i, 0));
                mark[i][0] = true;
            }
            if (hangar[i][m - 1] == 'R') {
                queue.add(new Pair(i, m - 1));
                mark[i][m - 1] = true;
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int index = 0; index < DIR.length; index++) {
                int[] dir = DIR[index];
                int xx = pair.x + dir[0];
                int yy = pair.y + dir[1];
                char expected = LETTER[index];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (hangar[xx][yy] == expected && !mark[xx][yy]) {
                        mark[xx][yy] = true;
                        queue.add(new Pair(xx, yy));
                    }
                }
            }
        }

        int ans = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mark[i][j]) {
                    ans--;
                }
            }
        }

        return ans;
    }

}
