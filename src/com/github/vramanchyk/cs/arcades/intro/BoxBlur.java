package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class BoxBlur {

    int[][] boxBlur(int[][] image) {
        int[][] result = new int[image.length - 2][image[0].length - 2];

        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[0].length - 1; j++) {

                int pixel = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        pixel += image[i + x][j + y];
                    }
                }

                result[i - 1][j - 1] = pixel / 9;
            }
        }

        return result;
    }

}
