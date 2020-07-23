package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class DigitDegree {

    int sum(int n) {
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

    int digitDegree(int n) {
        int degree = 0;

        while (n > 9) {
            n = sum(n);
            degree++;
        }

        return degree;
    }

}
