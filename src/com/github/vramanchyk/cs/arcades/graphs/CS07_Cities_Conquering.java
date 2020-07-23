package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS07_Cities_Conquering {

    int[] citiesConquering(int n, int[][] roads) {
        int[] cardinality = new int[n];

        int[][] matrix = new int[n][n];
        int[] edge = new int[n];

        int[] days = new int[n];
        Arrays.fill(days, -1);

        for (int[] road : roads) {
            matrix[road[0]][edge[road[0]]++] = road[1];
            matrix[road[1]][edge[road[1]]++] = road[0];

            cardinality[road[0]]++;
            cardinality[road[1]]++;
        }

        int day = 1;
        while (true) {

            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (cardinality[i] < 2 && days[i] < 0) {
                    days[i] = day;
                    found = true;
                }
            }

            for (int i = 0; i < n; i++) {
                if (days[i] == day) {
                    for (int index = 0; index < edge[i]; index++) {
                        cardinality[matrix[i][index]]--;
                    }
                }
            }

            if (!found) {
                break;
            }

            day++;
        }

        return days;
    }
}
