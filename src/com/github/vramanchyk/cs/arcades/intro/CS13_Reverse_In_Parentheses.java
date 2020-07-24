package com.github.vramanchyk.cs.arcades.intro;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS13_Reverse_In_Parentheses {

    String reverseInParentheses(String str) {
        Deque<Character> deque = new LinkedList<>();
        Deque<Character> current = new LinkedList<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {

                while (!deque.isEmpty() && '(' != deque.peek()) {
                    current.addFirst(deque.pop());
                }

                deque.poll();

                while (!current.isEmpty()) {
                    deque.push(current.pollLast());
                }

            } else {
                deque.push(c);
            }
        }

        String result = "";
        while (!deque.isEmpty()) {
            result = deque.poll() + result;
        }

        return result;
    }
}
