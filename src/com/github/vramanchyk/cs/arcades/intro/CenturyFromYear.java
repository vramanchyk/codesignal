package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CenturyFromYear {

    int centuryFromYear(int year) {
        return year / 100 + (year % 100 == 0 ? 0 : 1);
    }
}
