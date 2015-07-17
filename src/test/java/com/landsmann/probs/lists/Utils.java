package com.landsmann.probs.lists;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class Utils {

    private Utils() {
    }

    public static <T> void checkList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("List is null or empty for Pete's sake!");
        }
    }
}
