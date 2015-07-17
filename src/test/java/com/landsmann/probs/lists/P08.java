package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P08 (**) Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
 * Example:
 * <p>
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
public class P08 {

    public <T> List<T> compress(List<T> list) {
        Utils.checkList(list);
        List<T> result = new ArrayList<>();
        list.stream()
                .forEach(e -> {
                    if (result.isEmpty() || !e.equals(result.get(result.size() - 1))) {
                        result.add(e);
                    }
                });
        return result;
    }

    @Test
    public void testCompress() {
        P08 t = new P08();
        List<Character> list = Arrays.asList('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e');
        Character[] expected = {'a', 'b', 'c', 'a', 'd', 'e'};
        Character[] result = new Character[6];
        result = t.compress(list).toArray(result);
        Assert.assertArrayEquals(expected, result);
    }
}
