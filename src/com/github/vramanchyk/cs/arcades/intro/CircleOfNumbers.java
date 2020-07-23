package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CircleOfNumbers {

    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

}
