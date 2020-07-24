package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS27_Variable_Name {

    boolean variableName(String name) {
        for (char ch : name.toLowerCase().toCharArray()) {
            if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || ch == '_')) {
                return false;
            }
        }

        final char ch = name.charAt(0);
        return ch < '0' || ch > '9';
    }

}
