package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ValidTime {

    boolean validTime(String time) {
        String[] split = time.split(":");

        return split.length == 2 && Integer.valueOf(split[0]) < 24 && Integer.valueOf(split[1]) < 60;
    }

}
