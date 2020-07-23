package com.github.vramanchyk.cs.arcades.graphs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS03_Efficient_Road_Network {

    boolean efficientRoadNetwork(int n, int[][] roads) {
        boolean[][] matrix = new boolean[n][n];
        for (int[] road : roads) {
            matrix[road[0]][road[1]] = matrix[road[1]][road[0]] = true;
        }

        boolean[] was = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(was, false);

            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    was[j] = true;
                    for (int k = 0; k < n; k++) {
                        if (matrix[j][k]) {
                            was[k] = true;
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (i != j && !was[j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
