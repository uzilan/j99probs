package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * P05 (*) Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
public class P05 {

    public <T> List<T> reverse(List<T> list) {
        if (list.isEmpty()) {
            return list;
        }
        Utils.checkList(list);
        return list.stream()
                .sorted((firstElement, secondElement) -> -1)
                .collect(Collectors.toList());
    }

    @Test
    public void testP05() {
        P05 t = new P05();
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
        Integer[] expected = {8, 5, 3, 2, 1, 1};
        Integer[] result = new Integer[6];
        result = t.reverse(list).toArray(result);
        Assert.assertArrayEquals(expected, result);
    }
}
