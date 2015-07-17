package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P07 (**) Flatten a nested list structure.
 * Example:
 * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 * <p>
 * o_O, in Java you can't really do that. Instead we use:
 * flatten(List(List(1, 1), List(2), List(3), List(5, 8)))
 * <p>
 * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */
public class P07 {

    public <T> List<T> flatten(List<List<T>> list) {
        Utils.checkList(list);
        return list.stream()
                .reduce(new ArrayList<>(), (accumulator, nextElement) -> {
                    accumulator.addAll(nextElement);
                    return accumulator;
                });
    }

    @Test
    public void testFlatten() {
        P07 t = new P07();
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(5, 8));
        Integer[] expected = {1, 1, 2, 3, 5, 8};
        Integer[] result = new Integer[6];
        result = t.flatten(list).toArray(result);
        Assert.assertArrayEquals(expected, result);
    }
}
