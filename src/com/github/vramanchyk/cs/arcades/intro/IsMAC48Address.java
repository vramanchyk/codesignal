package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class IsMAC48Address {

    boolean isValid(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F');
    }

    boolean isMAC48Address(String inputString) {
        if (inputString.startsWith("-") || inputString.endsWith("-")) {
            return false;
        }
        String[] split = inputString.split("-");
        return split.length == 6 && Arrays.stream(split).allMatch(group -> {
            return group.length() == 2 && isValid(group.charAt(0)) && isValid(group.charAt(1));
        });
    }

}
