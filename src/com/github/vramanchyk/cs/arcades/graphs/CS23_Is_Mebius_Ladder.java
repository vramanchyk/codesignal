package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS23_Is_Mebius_Ladder {

    boolean hasLoop(int dest, int cur, int prev, int count, int[][] matrix) {
        if (count == 0) {
            return dest == cur;
        }
        for (int t = 0; t < 3; t++) {
            if (prev != matrix[cur][t]) {
                if (hasLoop(dest, matrix[cur][t], cur, count - 1, matrix)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean checkMatrix(int n, int[][] matrix) {

        if (n == 6) {
            return true;
        }

        int broken = 0;
        for (int i = 0; i < n; i++) {

            int loops = 0;
            for (int t = 0; t < 3; t++) {
                if (hasLoop(i, matrix[i][t], i, 3, matrix)) {
                    loops++;
                }
            }

            if (loops != 3) {
                return false;
            }
        }

        return true;
    }

    boolean isMobiusLadder(int n, int[][] ladder) {
        if (n == 2) {
            return ladder.length == 1;
        }

        if (ladder.length != n + n / 2) {
            return false;
        }

        final int[][] matrix = new int[n][3];
        final int[] count = new int[n];

        for (int[] edge : ladder) {
            int v1 = edge[0];
            int v2 = edge[1];

            if (count[v1] >= 3 || count[v2] >= 3) {
                return false;
            }

            matrix[v1][count[v1]++] = v2;
            matrix[v2][count[v2]++] = v1;
        }

        return Arrays.stream(count).allMatch(t -> t == 3) && checkMatrix(n, matrix);
    }
}
