package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ArrayReplace {

    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        return Arrays.stream(inputArray).map(i -> i == elemToReplace ? substitutionElem : i).toArray();
    }

}
