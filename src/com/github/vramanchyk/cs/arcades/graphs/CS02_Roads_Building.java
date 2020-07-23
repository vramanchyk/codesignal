package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS02_Roads_Building {

    int[][] roadsBuilding(int cities, int[][] roads) {

        int count = (cities * (cities - 1)) / 2;

        boolean[][] matrix = new boolean[cities][cities];
        for (int[] road : roads) {
            matrix[road[0]][road[1]] = true;
            matrix[road[1]][road[0]] = true;
            count--;
        }

        int[][] result = new int[count][2];
        int index = 0;

        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (!matrix[i][j]) {
                    result[index][0] = i;
                    result[index][1] = j;
                    index++;
                }
            }
        }

        return result;
    }

}
