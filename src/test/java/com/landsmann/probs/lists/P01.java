package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * P01 (*) Find the last element of a list.
 * Example:
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 */
public class P01 {

    public <T> T last(List<T> list) {
        Utils.checkList(list);
        return list.stream()
                .reduce((accumulator, nextElement) -> nextElement)
                .get();
    }

    @Test
    public void testLast() {
        P01 t = new P01();
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
        Integer last = t.last(list);
        Assert.assertEquals((Integer) 8, last);
    }
}
