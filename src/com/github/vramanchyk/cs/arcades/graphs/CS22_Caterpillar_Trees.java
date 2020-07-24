package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS22_Caterpillar_Trees {

    private static class Graph {

        class Edge {

            final int v, idx;

            Edge(int v, int idx) {
                this.v = v;
                this.idx = idx;
            }
        }

        final int[] value;

        final int[] lastIndex;

        final int[] prevIndex;

        final int[] indexes;

        int len;

        Graph(int n, int[][] edges) {
            lastIndex = new int[n];

            int tl = 2 * edges.length + 2;

            value = new int[tl];
            prevIndex = new int[tl];
            indexes = new int[tl];

            Arrays.fill(lastIndex, -1);
            Arrays.fill(value, -1);
            Arrays.fill(prevIndex, -1);
            Arrays.fill(indexes, -1);

            int edgeIndex = 0;
            for (int[] v : edges) {
                addEdge(v[0], v[1], edgeIndex);
                addEdge(v[1], v[0], edgeIndex);
                edgeIndex++;
            }
        }

        void addEdge(int v1, int v2, int idx) {
            value[len] = v2;
            prevIndex[len] = lastIndex[v1];
            indexes[len] = idx;

            lastIndex[v1] = len++;
        }

        Iterable<Edge> adjacent(final int v) {
            return () -> new Iterator<Edge>() {

                int index = lastIndex[v];

                @Override
                public boolean hasNext() {
                    return index >= 0;
                }

                @Override
                public Edge next() {
                    int result = value[index];
                    int idx = indexes[index];
                    index = prevIndex[index];
                    return new Edge(result, idx);
                }
            };
        }
    }

    boolean[] visited;

    boolean[] visitedEdges;

    Graph g;

    boolean hasCycles;

    boolean hasOverhead;

    int checkTree(int v, int deep) {

        visited[v] = true;

        int countDepth = 0;

        int depth = deep;

        for (Graph.Edge e : g.adjacent(v)) {
            if (!visited[e.v]) {

                visitedEdges[e.idx] = true;
                int subtreeDepth = checkTree(e.v, deep + 1);

                depth = Math.max(depth, subtreeDepth);

                if (subtreeDepth - deep > 1) {
                    countDepth++;
                }
            } else {
                if (!visitedEdges[e.idx]) {
                    hasCycles = true;
                }
            }
        }

        if ((deep > 1 && countDepth > 1) || countDepth > 2) {
            hasOverhead = true;
        }

        return depth;
    }

    int solve(int v) {
        hasCycles = hasOverhead = false;

        checkTree(v, 0);
        if (hasCycles) {
            return 0;
        }
        if (hasOverhead) {
            return 1;
        }
        return 2;
    }

    int[] caterpillarTrees(int n, int[][] edges) {
        g = new Graph(n, edges);

        visited = new boolean[n];
        visitedEdges = new boolean[2 * edges.length + 1];

        int treesCount = 0, catCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int res = solve(i);
                if (res == 1) {
                    treesCount++;
                }
                if (res == 2) {
                    treesCount++;
                    catCount++;
                }
            }
        }

        return new int[]{treesCount, catCount};
    }
}
