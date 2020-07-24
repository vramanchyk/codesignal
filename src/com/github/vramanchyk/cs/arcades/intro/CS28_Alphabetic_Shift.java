package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS28_Alphabetic_Shift {

    String alphabeticShift(String inputString) {
        String res = "";
        for (char ch : inputString.toCharArray())
            res += (char) ((ch - 'a' + 1) % 26 + 'a');
        return res;
    }

}
