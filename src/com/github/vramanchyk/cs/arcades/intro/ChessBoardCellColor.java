package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class ChessBoardCellColor {

    int[] getCell(String s) {
        return new int[]{s.charAt(0) - 'A', s.charAt(1) - '0'};
    }

    boolean chessBoardCellColor(String cell1, String cell2) {
        final int[] c1 = getCell(cell1);
        final int[] c2 = getCell(cell2);

        return (c1[0] + c1[1]) % 2 == (c2[0] + c2[1]) % 2;
    }

}
