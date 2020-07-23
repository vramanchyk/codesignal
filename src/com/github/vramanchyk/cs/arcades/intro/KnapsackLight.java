package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class KnapsackLight {

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        } else if (weight1 <= maxW && weight2 <= maxW) {
            return Math.max(value1, value2);
        } else {
            return weight1 <= maxW ? value1 : weight2 <= maxW ? value2 : 0;
        }
    }

}
