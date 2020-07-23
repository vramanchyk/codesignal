package com.github.vramanchyk.cs.arcades.intro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class FileNaming {

    String[] fileNaming(String[] names) {
        final Set<String> set = new HashSet<>();

        return Arrays.stream(names).map(name -> {
            if (!set.contains(name)) {

                set.add(name);
                return name;

            } else {
                int number = 1;
                while (set.contains(name + "(" + number + ")")) {
                    number++;
                }
                set.add(name + "(" + number + ")");
                return name + "(" + number + ")";
            }
        }).toArray(String[]::new);
    }

}
