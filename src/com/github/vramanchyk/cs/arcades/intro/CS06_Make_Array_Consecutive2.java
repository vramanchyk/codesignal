package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS06_Make_Array_Consecutive2 {

    int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);

        int ans = 0;
        for (int i = 1; i < statues.length; i++) {
            ans += statues[i] - statues[i - 1] - 1;
        }

        return ans;
    }
}
