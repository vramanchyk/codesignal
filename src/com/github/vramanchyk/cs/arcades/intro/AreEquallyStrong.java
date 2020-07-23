package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class AreEquallyStrong {

    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight) &&
                Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight);
    }

}
