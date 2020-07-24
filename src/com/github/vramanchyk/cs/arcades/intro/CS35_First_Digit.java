package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS35_First_Digit {

    char firstDigit(String inputString) {
        for (char ch : inputString.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return ch;
            }
        }

        return 0;
    }

}
