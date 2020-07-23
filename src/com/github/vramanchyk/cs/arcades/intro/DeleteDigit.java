package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class DeleteDigit {

    int deleteDigit(int n) {
        int ten = 1;
        while (ten <= n) {
            ten *= 10;
        }

        int ans = 0;
        while (ten > 1) {
            ans = Math.max(ans, (n / ten) * (ten / 10) + n % (ten / 10));
            ten /= 10;
        }

        return ans;
    }
}
