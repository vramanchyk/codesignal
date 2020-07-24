package com.github.vramanchyk.cs.arcades.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS21_Burning_The_Wood {

    private static class Graph {

        final int[] value;

        final int[] lastIndex;

        final int[] prevIndex;

        int len;

        public Graph(int n, int[][] map) {
            lastIndex = new int[n];

            int tl = 2 * map.length + 1;

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
            return new Iterable<Integer>() {
                @Override
                public Iterator<Integer> iterator() {
                    return new Iterator<Integer>() {

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
            };
        }
    }

    int[] burningTheWood(int n, int[][] wmap, int start, int k) {
        final Graph g = new Graph(n, wmap);

        final int[] burned = new int[n];
        final Queue<Integer> queue = new ArrayDeque<>();

        Arrays.fill(burned, -1);

        burned[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int ver = queue.poll();
            if (burned[ver] == k) {
                continue;
            }

            for (int t : g.adjacent(ver)) {
                if (burned[t] == -1) {
                    burned[t] = burned[ver] + 1;
                    queue.add(t);
                }
            }
        }

        return java.util.stream.IntStream.range(0, n).filter(i -> burned[i] != -1).toArray();
    }
}
