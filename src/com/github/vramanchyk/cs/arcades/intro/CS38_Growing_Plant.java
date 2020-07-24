package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS38_Growing_Plant {

    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int height = 0;
        int day = 0;

        while (height < desiredHeight) {
            day++;
            if (height + upSpeed >= desiredHeight) {
                break;
            }
            height += upSpeed - downSpeed;
        }

        return day;
    }

}
