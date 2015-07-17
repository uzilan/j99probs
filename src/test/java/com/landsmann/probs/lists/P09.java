package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * Example:
 * <p>
 * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */
public class P09 {

    class Result<T> {
        List<List<T>> result = new ArrayList<>();
        List<T> tempList = new ArrayList<>();
        T lastElement;
    }

    public <T> List<List<T>> pack(List<T> list) {
        Utils.checkList(list);
        final Result<T> r = new Result<>();

        list.stream()
                .forEach(e -> {
                    if (!r.tempList.isEmpty() && !e.equals(r.lastElement)) {
                        r.result.add(r.tempList);
                        r.tempList = new ArrayList<>();
                    }
                    r.tempList.add(e);
                    r.lastElement = e;
                });
        r.result.add(r.tempList);
        return r.result;
    }

    @Test
    public void testPack() {
        P09 t = new P09();
        List<Character> list = Arrays.asList('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e');
        List<List<Character>> expected = Arrays.asList(Arrays.asList('a', 'a', 'a', 'a'), Arrays.asList('b'), Arrays.asList('c', 'c'), Arrays.asList('a', 'a'), Arrays.asList('d'), Arrays.asList('e', 'e', 'e', 'e'));
        List<List<Character>> result = t.pack(list);
        Assert.assertEquals(expected, result);
    }
}
