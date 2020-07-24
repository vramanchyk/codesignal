package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS49_Line_Encoding {

    String lineEncoding(String s) {
        String result = "";

        char activeChar = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch != activeChar) {
                if (count > 0) {
                    result += count > 1 ? count : "";
                    result += activeChar;
                }

                activeChar = ch;
                count = 1;

            } else {
                count++;
            }
        }

        if (count > 0) {
            result += count > 1 ? count : "";
            result += activeChar;
        }

        return result;
    }

}
