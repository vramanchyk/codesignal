package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class SpiralNumbers {

    final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int[][] spiralNumbers(int n) {

        int[][] result = new int[n][n];

        int dir = 0, x = 0, y = -1;

        for (int i = 1; i <= n * n; i++) {
            while (true) {
                int tx = x + DIR[dir][0];
                int ty = y + DIR[dir][1];

                if (tx < 0 || tx >= n || ty < 0 || ty >= n || result[tx][ty] > 0) {
                    dir = (dir + 1) % 4;
                } else {
                    break;
                }
            }

            x += DIR[dir][0];
            y += DIR[dir][1];

            result[x][y] = i;
        }

        return result;
    }

}
