package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS31_Deposit_Profit {

    int depositProfit(int deposit, int rate, int threshold) {
        int year = 0;

        while (deposit < threshold) {
            deposit = deposit + (int) (0.01 * deposit * rate);
            year++;
        }

        return year;
    }

}
