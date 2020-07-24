package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS22_Avoid_Obstacles {

    int avoidObstacles(int[] array) {
        for (int jump = 2; ; jump++) {
            boolean found = true;
            for (int num : array) {
                if (num % jump == 0) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return jump;
            }
        }
    }

}
