package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS05_Naming_Roads {

    boolean namingRoads(int[][] roads) {
        int len = roads.length;
        int[][] sortedRoads = new int[2][len];

        for (int[] road : roads) {
            sortedRoads[0][road[2]] = road[0];
            sortedRoads[1][road[2]] = road[1];
        }

        for (int i = 1; i < len; i++) {
            for (int k1 = 0; k1 < 2; k1++) {
                for (int k2 = 0; k2 < 2; k2++) {
                    if (sortedRoads[k1][i - 1] == sortedRoads[k2][i]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
