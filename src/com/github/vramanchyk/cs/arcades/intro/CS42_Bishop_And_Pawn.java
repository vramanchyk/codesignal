package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS42_Bishop_And_Pawn {

    int[] position(String s) {
        return new int[]{s.charAt(0) - 'A', s.charAt(1) - '1'};
    }

    boolean bishopAndPawn(String bishop, String pawn) {
        int[] b = position(bishop);
        int[] p = position(pawn);

        return Math.abs(b[0] - p[0]) == Math.abs(b[1] - p[1]);
    }

}
