package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS15_Add_Border {

    String[] addBorder(String[] picture) {
        final String[] result = new String[picture.length + 2];

        String border = "";
        for (int i = 0; i < picture[0].length() + 2; i++) {
            border += '*';
        }

        result[0] = result[picture.length + 1] = border;

        for (int i = 1; i <= picture.length; i++) {
            result[i] = '*' + picture[i - 1] + '*';
        }

        return result;
    }
}
