package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS52_Longest_Word {

    String longestWord(String text) {

        String answer = "";
        String currentWord = "";


        for (char ch : text.toCharArray()) {
            if (!Character.isLetter(ch)) {
                if (currentWord.length() > answer.length()) {
                    answer = currentWord;
                }
                currentWord = "";
            } else {
                currentWord += ch;
            }
        }

        if (currentWord.length() > answer.length()) {
            answer = currentWord;
        }

        return answer;
    }

}
