package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS20_Is_Pseudoforest {

    private boolean[] visited;

    private boolean[] marked;

    private int[] value;

    private int[] last;

    private int[] prev;

    private int[] en;

    private int len;

    private int cycles;

    void findCycles(int ver, int p) {

        marked[ver] = true;

        int index = last[ver];

        while (index >= 0) {
            int t = value[index];

            if (t != p) {
                if (!visited[t]) {
                    visited[t] = true;
                    findCycles(t, ver);
                    visited[t] = false;
                } else {
                    cycles++;
                }
            }

            index = prev[index];
        }
    }

    void addEdge(int v1, int v2, int t) {
        value[len] = v2;
        prev[len] = last[v1];
        en[len] = t;
        last[v1] = len;
        len++;
    }

    boolean isPseudoforest(int n, int[][] wmap) {

        last = new int[n];
        visited = new boolean[n];
        marked = new boolean[n];

        int tl = 2 * wmap.length + 1;

        value = new int[tl];
        prev = new int[tl];
        en = new int[tl];

        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);

        int edge = 0;
        for (int[] v : wmap) {
            addEdge(v[0], v[1], edge);
            addEdge(v[1], v[0], edge++);
        }

        for (int v = 0; v < n; v++) {
            if (!marked[v]) {
                visited[v] = true;
                cycles = 0;

                findCycles(v, -1);

                if (cycles > 2) {
                    return false;
                }
            }
        }

        return true;
    }

}
