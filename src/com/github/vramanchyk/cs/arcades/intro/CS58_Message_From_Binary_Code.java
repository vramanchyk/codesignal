package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS58_Message_From_Binary_Code {

    String messageFromBinaryCode(String code) {

        int currentByte = 0;
        String message = "";

        for (int index = 1; index <= code.length(); index++) {
            currentByte = (currentByte << 1) + (code.charAt(index - 1) - 48);
            if (index % 8 == 0) {
                message += "" + (char) currentByte;
                currentByte = 0;
            }
        }

        return message;
    }

}
