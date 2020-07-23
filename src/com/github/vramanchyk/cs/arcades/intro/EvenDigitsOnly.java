package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class EvenDigitsOnly {

    boolean evenDigitsOnly(int n) {
        while (n > 0) {
            if (n % 2 != 0) {
                return false;
            }

            n /= 10;
        }

        return true;
    }
    
}
