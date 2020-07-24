package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS46_Elections_Winners {

    int electionsWinners(int[] votes, int k) {
        long max = Arrays.stream(votes).max().orElse(0);

        if (k == 0) {
            return (int) Arrays.stream(votes).filter(vote -> vote == max).count() > 1 ? 0 : 1;
        }

        return (int) Arrays.stream(votes).filter(vote -> vote + k > max).count();
    }
}
