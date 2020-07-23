package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS09_Living_On_The_Roads {

    boolean[][] livingOnTheRoads(boolean[][] roadRegister) {
        final int n = roadRegister.length;

        int[][] roads = new int[n][n];

        int roadsCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (roadRegister[i][j]) {
                    roads[i][j] = roads[j][i] = roadsCount++;
                }
            }
        }

        boolean[][] result = new boolean[roadsCount][roadsCount];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (roadRegister[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (roadRegister[k][j]) {
                            result[roads[i][j]][roads[k][j]] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < roadsCount; i++) {
            result[i][i] = false;
        }

        return result;
    }

}
