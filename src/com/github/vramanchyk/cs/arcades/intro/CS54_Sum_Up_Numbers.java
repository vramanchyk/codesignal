package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS54_Sum_Up_Numbers {

    int sumUpNumbers(String inputString) {
        int sum = 0;
        int number = 0;

        for (char ch : inputString.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                number = number * 10 + ch - '0';
            } else {
                sum += number;
                number = 0;
            }
        }

        sum += number;

        return sum;
    }

}
