package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS24_Tree_Diameter {

    private static class Graph {

        final int[] value;

        final int[] lastIndex;

        final int[] prevIndex;

        int len;

        Graph(int n, int[][] map) {
            lastIndex = new int[n];

            int tl = 2 * map.length + 2;

            value = new int[tl];
            prevIndex = new int[tl];

            Arrays.fill(lastIndex, -1);
            Arrays.fill(prevIndex, -1);

            for (int[] v : map) {
                addEdge(v[0], v[1]);
                addEdge(v[1], v[0]);
            }
        }

        void addEdge(int v1, int v2) {
            value[len] = v2;
            prevIndex[len] = lastIndex[v1];
            lastIndex[v1] = len;

            len++;
        }

        Iterable<Integer> adjacent(final int v) {
            return () -> new Iterator<Integer>() {

                int index = lastIndex[v];

                @Override
                public boolean hasNext() {
                    return index >= 0;
                }

                @Override
                public Integer next() {
                    int result = value[index];
                    index = prevIndex[index];
                    return result;
                }
            };
        }
    }

    Graph g;

    int diametr = 0;

    int[] depth;

    int[] order;

    int[] position;

    int[] prev;

    void solve(int n) {

        int head = 0, tail = 0;
        order[head] = 0;
        position[0] = 0;
        prev[0] = -1;

        while (head <= tail) {
            int ver = order[head];
            int pr = prev[head++];

            for (int t : g.adjacent(ver)) {
                if (t != pr) {
                    tail++;
                    order[tail] = t;
                    position[t] = tail;
                    prev[tail] = ver;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int ver = order[i];
            int t1 = -1, t2 = -1, height = -1;
            for (int t : g.adjacent(ver)) {
                if (position[t] < position[ver]) {
                    continue;
                }
                int subtree = depth[t];

                if (t1 == -1) {
                    t1 = subtree;
                } else if (subtree >= t1) {
                    t2 = t1;
                    t1 = subtree;
                } else if (subtree > t2) {
                    t2 = subtree;
                }

                height = Math.max(height, subtree);
            }

            if (t1 != -1 && t2 != -1) {
                diametr = Math.max(diametr, t1 + t2 + 2);
            } else if (t1 != -1) {
                diametr = Math.max(diametr, t1 + 1);
            }

            diametr = Math.max(diametr, height + 1);

            depth[ver] = height + 1;
        }
    }

    int treeDiameter(int n, int[][] tree) {
        g = new Graph(n, tree);
        depth = new int[n + 10];
        order = new int[n + 1];
        position = new int[n + 1];
        prev = new int[n + 1];
        solve(n);
        return diametr;
    }
}
