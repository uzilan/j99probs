package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * P04 (*) Find the number of elements of a list.
 * Example:
 * scala> length(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 6
 */
public class P04 {

    public <T> long length(List<T> list) {
        if (list.isEmpty()) {
            return 0;
        }
        Utils.checkList(list);
        return list.stream().count();
    }

    @Test
    public void testLength() {
        P04 t = new P04();
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
        Long length = 6L;
        Long result = t.length(list);
        Assert.assertEquals(length, result);
    }
}
