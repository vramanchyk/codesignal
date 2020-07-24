package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS18_Is_Wood_Magical {

    private int[] visited;

    private int[] value;

    private int[] last;

    private int[] prev;

    private int len;

    private final Queue<Integer> queue = new ArrayDeque<>();

    boolean hasEvenCycle(int v) {
        visited[v] = 1;
        queue.add(v);

        while (!queue.isEmpty()) {
            int ver = queue.poll();
            int index = last[ver];

            while (index >= 0) {
                int t = value[index];

                if (t != ver) {
                    if (visited[t] == 0) {
                        visited[t] = visited[ver] + 1;
                        queue.add(t);
                    } else if (Math.abs(visited[t] - visited[ver]) % 2 == 0) {
                        return false;
                    }
                }

                index = prev[index];
            }
        }

        return true;
    }

    void addEdge(int v1, int v2) {
        value[len] = v2;
        prev[len] = last[v1];
        last[v1] = len;
        len++;
    }

    boolean isWoodMagical(int n, int[][] wmap) {

        last = new int[n];
        visited = new int[n];

        int tl = 2 * wmap.length + 1;

        value = new int[tl];
        prev = new int[tl];

        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);

        for (int[] v : wmap) {
            if (v[0] == v[1]) {
                return false;
            }
            addEdge(v[0], v[1]);
            addEdge(v[1], v[0]);
        }

        for (int v = 0; v < n; v++) {
            if (visited[v] == 0) {
                if (!hasEvenCycle(v)) {
                    return false;
                }
            }
        }

        return true;
    }
}
