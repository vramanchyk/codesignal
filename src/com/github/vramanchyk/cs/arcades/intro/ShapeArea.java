package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ShapeArea {

    int shapeArea(int n) {
        if (n == 1) {
            return 1;
        }

        return (2 + 2 * (n - 2)) * (n - 1) + (2 * n - 1);
    }

}
