package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS21_Is_IPv4_Address {

    boolean isIPv4Address(String inputString) {
        String[] split = inputString.split("\\.");
        if (split.length == 4) {
            for (int i = 0; i < 4; i++) {
                try {
                    int byteValue = Integer.parseInt(split[i]);
                    if (!(byteValue >= 0 && byteValue <= 255)) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

}
