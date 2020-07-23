package com.github.vramanchyk.cs.arcades.intro;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class FindEmailDomain {

    String findEmailDomain(String address) {
        return address.substring(address.lastIndexOf("@") + 1);
    }

}
