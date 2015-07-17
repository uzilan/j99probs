package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * P02 (*) Find the last but one element of a list.
 * Example:
 * scala> penultimate(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 5
 */
public class P02 {

    public <T> T penultimate(List<T> list) {
        Utils.checkList(list);
        return list.stream()
                .skip(list.size() - 2)
                .findFirst().get();
    }

    @Test
    public void testPenultimate() {
        P02 t = new P02();
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
        Integer penultimate = t.penultimate(list);
        Assert.assertEquals((Integer) 5, penultimate);
    }
}
