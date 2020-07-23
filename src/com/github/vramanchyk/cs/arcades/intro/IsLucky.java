package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class IsLucky {

    boolean isLucky(int n) {

        int t = n, digits = 0, sum = 0, count = 0;

        while (t > 0) {
            t /= 10;
            digits++;
        }

        int half = digits / 2;

        while (n > 0) {
            if (count++ < half) {
                sum += n % 10;
            } else {
                sum -= n % 10;
            }

            n /= 10;
        }

        return sum == 0;
    }
}
