package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS04_Adjacent_Elements_Product {

    int adjacentElementsProduct(int[] array) {
        
        int max = array[0] * array[1];
        for (int i = 2; i < array.length; i++) {
            max = Math.max(max, array[i - 1] * array[i]);
        }

        return max;
    }

}
