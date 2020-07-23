package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS11_Count_Stars {

    private int n;

    private int[] visited;

    private Queue<Integer> queue = new ArrayDeque<>();

    boolean isStar(int t, boolean[][] a) {
        visited[t] = 1;
        queue.add(t);

        int levels = 1;
        int starCount = 0;

        boolean first = false;
        boolean hasLoop = false;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            int neighbours = 0;
            for (int i = 0; i < n; i++) {

                if (a[v][i]) {
                    neighbours++;
                    if (visited[i] == 0) {
                        visited[i] = visited[v] + 1;
                        levels = Math.max(levels, visited[i]);
                        queue.add(i);
                    }

                    if (v == i || Math.abs(visited[i] - visited[v]) > 1) {
                        hasLoop = true;
                    }
                }
            }

            if (neighbours > 1) {
                if (v == t) {
                    first = true;
                }
                starCount++;
            }
        }

        if (hasLoop || levels < 2) {
            return false;
        }

        if (first) {
            return starCount == 1 && levels == 2;
        } else {
            return starCount <= 1 && levels <= 3;
        }
    }

    int countStars(boolean[][] a) {
        n = a.length;
        visited = new int[n];

        int startsCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && isStar(i, a)) {
                startsCount++;
            }
        }

        return startsCount;
    }
}
