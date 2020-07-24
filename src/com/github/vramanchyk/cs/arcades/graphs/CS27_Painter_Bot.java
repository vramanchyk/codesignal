package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS27_Painter_Bot {

    private static class Pair {

        final int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    final Queue<Pair> queue = new ArrayDeque<>();

    List<Pair> getPaints(int x, int y, int step, int[][] canvas, int[][] mark, int d) {
        final int n = canvas.length;
        final int m = canvas[0].length;

        final List<Pair> result = new ArrayList<>();

        queue.add(new Pair(x, y));
        mark[x][y] = step;
        int color = canvas[x][y];

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();
            result.add(pair);

            for (int[] dir : DIR) {
                int xx = pair.x + dir[0];
                int yy = pair.y + dir[1];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (mark[xx][yy] < step && Math.abs(canvas[xx][yy] - color) <= d) {
                        queue.add(new Pair(xx, yy));
                        mark[xx][yy] = step;
                    }
                }
            }
        }

        return result;
    }

    int[][] painterBot(int[][] canvas, int[][] operations, int d) {

        final int[][] mark = new int[canvas.length][canvas[0].length];

        int step = 1;
        for (int[] op : operations) {
            for (Pair pair : getPaints(op[0], op[1], step, canvas, mark, d)) {
                canvas[pair.x][pair.y] = op[2];
            }
            step++;
        }

        return canvas;
    }
}
