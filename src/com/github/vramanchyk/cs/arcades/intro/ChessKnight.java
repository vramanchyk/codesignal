package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ChessKnight {

    int[] position(String s) {
        return new int[]{s.charAt(0) - 'a', s.charAt(1) - '1'};
    }

    final int[][] DIR = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    int chessKnight(String cell) {
        int[] pos = position(cell);

        int answer = 0;
        for (int[] dir : DIR) {
            final int x = pos[0] + dir[0];
            final int y = pos[1] + dir[1];

            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                answer++;
            }
        }

        return answer;
    }

}
