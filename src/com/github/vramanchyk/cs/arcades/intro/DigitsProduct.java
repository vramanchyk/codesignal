package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class DigitsProduct {

    int product(int n) {
        int result = 1;
        while (n > 0) {
            result *= (n % 10);
            n /= 10;
        }

        return result;
    }

    int digitsProduct(int product) {
        for (int i = 1; i <= 100_000; i++) {
            if (product(i) == product) {
                return i;
            }
        }

        return -1;
    }

}
