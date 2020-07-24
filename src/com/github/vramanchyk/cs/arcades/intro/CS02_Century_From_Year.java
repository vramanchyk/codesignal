package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS02_Century_From_Year {

    int centuryFromYear(int year) {
        return year / 100 + (year % 100 == 0 ? 0 : 1);
    }
}
