package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS31_Mobius_Conquer {

    private static class Triple {

        final int x, y, side;

        Triple(int x, int y, int side) {
            this.x = x;
            this.y = y;
            this.side = side;
        }
    }

    final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int n, m;

    final Queue<Triple> queue = new ArrayDeque<>();

    int[][][] findDistances(Triple start, int[][][] matrix) {
        queue.clear();
        queue.add(start);
        matrix[start.x][start.y][start.side] = 1;

        while (!queue.isEmpty()) {
            Triple triple = queue.poll();

            for (int[] dir : DIR) {
                int xx = triple.x + dir[0];
                int yy = triple.y + dir[1];
                int side = triple.side;

                if (yy < 0) {
                    yy = m - 1;
                    side ^= 1;
                }

                if (yy >= m) {
                    yy = 0;
                    side ^= 1;
                }

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {

                    if (matrix[xx][yy][side] == 0) {
                        matrix[xx][yy][side] = matrix[triple.x][triple.y][triple.side] + 1;
                        queue.add(new Triple(xx, yy, side));
                    }
                }
            }
        }

        return matrix;
    }

    int[][][] getMatrix(int[][] cells) {
        int[][][] matrix = new int[n][m][2];
        for (int[] cell : cells) {
            Triple t = triple(cell[1], cell[2], cell[0]);
            matrix[t.x][t.y][t.side] = -1;
        }
        return matrix;
    }

    Triple triple(int x, int y, int s) {
        return new Triple(x, y, s);
    }

    int[] mobiusConquer(int[] field, int[] ratiorg, int[] enemy, int[][] impassableCells) {
        n = field[0];
        m = field[1];

        final Triple ratiorgTriple = triple(ratiorg[1], ratiorg[2], ratiorg[0]);
        final int[][][] ratiorgDistances = findDistances(ratiorgTriple, getMatrix(impassableCells));

        final Triple enemyTriple = triple(enemy[1], enemy[2], enemy[0]);
        final int[][][] enemyDistances = findDistances(enemyTriple, getMatrix(impassableCells));

        int ratiorgCount = 0, enemyCount = 0;

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ratiorgDistances[i][j][k] < enemyDistances[i][j][k]) {
                        ratiorgCount++;
                    } else if (ratiorgDistances[i][j][k] > enemyDistances[i][j][k]) {
                        enemyCount++;
                    }
                }
            }
        }

        return new int[]{ratiorgCount, enemyCount};
    }
}
