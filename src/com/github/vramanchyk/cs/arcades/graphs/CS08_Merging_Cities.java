package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS08_Merging_Cities {

    boolean[][] mergingCities(boolean[][] roadRegister) {
        final int n = roadRegister.length;

        int citiesCount = n;
        int[] actualCities = new int[n];

        int merges = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0 && roadRegister[i - 1][i]) {
                actualCities[i] = i - 1 - merges;

                merges++;
                citiesCount--;

            } else {
                actualCities[i] = i - merges;
            }
        }

        boolean[][] result = new boolean[citiesCount][citiesCount];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[actualCities[i]][actualCities[j]] |= roadRegister[i][j];
            }
            result[actualCities[i]][actualCities[i]] = false;
        }

        return result;
    }

}
