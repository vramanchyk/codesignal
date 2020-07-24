package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS25_Squirrel_And_Nut {

    private static class Graph {

        final int[] value;

        final int[] lastIndex;

        final int[] prevIndex;

        int len;

        Graph(int n, int[] tree) {
            lastIndex = new int[n];

            int tl = 2 * tree.length + 4;

            value = new int[tl];
            prevIndex = new int[tl];

            Arrays.fill(lastIndex, -1);
            Arrays.fill(prevIndex, -1);

            for (int i = 0; i < tree.length; i += 2) {
                addEdge(tree[i] - 1, tree[i + 1] - 1);
                addEdge(tree[i + 1] - 1, tree[i] - 1);
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

    int[] tree;

    int[] parent;

    int[] treeParent;

    int[] level;

    int[] section;

    int[] sectionParent;

    int dep;

    void solve() {

        int head = 0, tail = 0;
        tree[head] = 0;
        parent[0] = -1;
        sectionParent[0] = -1;
        level[0] = 0;

        while (head <= tail) {
            int ver = tree[head];
            int pr = parent[head++];

            for (int t : g.adjacent(ver)) {
                if (t != pr) {
                    tail++;
                    tree[tail] = t;
                    level[t] = level[ver] + 1;
                    section[t] = level[t] / dep;

                    if (level[t] % dep == 0) {
                        sectionParent[t] = ver;
                    } else {
                        sectionParent[t] = sectionParent[ver];
                    }

                    parent[tail] = ver;
                    treeParent[t] = ver;
                }
            }
        }
    }

    int query(int a, int b) {
        while (sectionParent[a] != sectionParent[b]) {
            if (level[a] > level[b]) {
                a = sectionParent[a];
            } else {
                b = sectionParent[b];
            }
        }

        while (a != b) {
            if (level[a] > level[b]) {
                a = treeParent[a];
            } else {
                b = treeParent[b];
            }
        }

        return a;
    }

    void init(int[] tree) {
        int n = tree.length / 2 + 1;
        g = new Graph(n, tree);
        this.tree = new int[n + 1];
        parent = new int[n + 1];
        section = new int[n];
        sectionParent = new int[n];
        level = new int[n];
        treeParent = new int[n];
        dep = (int) (Math.sqrt(n) + 1);
    }

    boolean check(int a, int b, int c) {
        if (a == c || b == c) {
            return true;
        }

        int ab = query(a, b);

        if (ab == c) {
            return true;
        }

        if (level[ab] > level[c]) {
            return false;
        }

        int ac = query(a, c);
        int bc = query(b, c);

        if (bc == c && ac == ab) {
            return true;
        }

        if (ac == c && bc == ab) {
            return true;
        }

        return false;
    }

    boolean[] buildAnswer(int[][] triples) {
        boolean[] result = new boolean[triples.length];

        for (int index = 0; index < triples.length; index++) {
            result[index] = check(triples[index][0] - 1, triples[index][1] - 1, triples[index][2] - 1);
        }

        return result;
    }

    boolean[] squirrelAndNut(int[] tree, int[][] triples) {
        init(tree);
        solve();

        return buildAnswer(triples);
    }
}
