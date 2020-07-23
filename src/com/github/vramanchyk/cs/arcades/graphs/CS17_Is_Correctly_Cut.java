package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS17_Is_Correctly_Cut {

    private int n;

    private int[] color;

    private Queue<Integer> queue = new ArrayDeque<>();

    boolean solve(int v, boolean[][] a) {
        color[v] = 1;
        queue.add(v);

        while (!queue.isEmpty()) {
            int t = queue.poll();
            int expectedColor = color[t] == 1 ? 2 : 1;

            for (int i = 0; i < n; i++) {
                if (a[t][i]) {
                    if (color[i] == 0) {
                        color[i] = expectedColor;
                        queue.add(i);
                    } else if (color[i] != expectedColor) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    boolean isCorrectlyCut(boolean[][] adj) {
        n = adj.length;

        if (n % 2 != 0) {
            return false;
        }

        color = new int[n];

        int[] gn = new int[n];
        boolean[] usedGn = new boolean[n];

        int clr1 = 0, clr2 = 0;
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                components++;
                if (!solve(i, adj)) {
                    return false;
                }
            }
        }

        if (components != 1) {
            return false;
        }

        int expected = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    count++;
                    if (color[i] == color[j]) {
                        return false;
                    }
                }
            }
            if (expected == -1) {
                expected = count;
            }
            if (count != expected) {
                return false;
            }
        }

        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] == 1) {
                gn[i] = c1++;
            }
        }

        if (c1 != n - c1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == 2) {
                BitSet gns = new BitSet();
                for (int j = 0; j < n; j++) {
                    if (adj[i][j]) {
                        gns.set(gn[j]);
                    }
                }
                int tgn = -1;
                for (int j = 0; j < n / 2; j++) {
                    if (!usedGn[j] && !gns.get(j)) {
                        tgn = j;
                        break;
                    }
                }
                if (tgn < 0) {
                    return false;
                }
                usedGn[tgn] = true;
                gn[i] = tgn;
            }
        }

        return true;
    }
}
