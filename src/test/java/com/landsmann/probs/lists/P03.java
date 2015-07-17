package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * P03 (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 * Example:
 * <p>
 * scala> nth(2, List(1, 1, 2, 3, 5, 8))
 * res0: Int = 2
 */
public class P03 {

    class Index {
        int index;
    }

    public <T> T nth(int i, List<T> list) {
        Utils.checkList(list);
        Index index = new Index();
        return list.stream().reduce(null, (accumulator, nextElement) -> {
            if (index.index == i + 1) {
                return accumulator;
            } else {
                index.index++;
                return nextElement;
            }
        });
    }

    @Test
    public void testNth() {
        P03 t = new P03();
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
        Integer nth = t.nth(2, list);
        Assert.assertEquals((Integer) 2, nth);
    }
}
