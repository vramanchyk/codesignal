package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class CS44_Find_Email_Domain {

    String findEmailDomain(String address) {
        return address.substring(address.lastIndexOf("@") + 1);
    }

}
