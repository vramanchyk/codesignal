package com.github.vramanchyk.cs.arcades.graphs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS01_New_Road_System {

    boolean newRoadSystem(boolean[][] roadRegister) {
        for (int i = 0; i < roadRegister.length; i++) {
            int incomingCount = 0, outcomingCount = 0;
            for (int j = 0; j < roadRegister.length; j++) {
                incomingCount += roadRegister[j][i] ? 1 : 0;
                outcomingCount += roadRegister[i][j] ? 1 : 0;
            }

            if (incomingCount != outcomingCount) {
                return false;
            }
        }

        return true;
    }

}
