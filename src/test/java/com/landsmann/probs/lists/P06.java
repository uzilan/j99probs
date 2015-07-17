package com.landsmann.probs.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * P06 (*) Find out whether a list is a palindrome.
 * Example:
 * scala> isPalindrome(List(1, 2, 3, 2, 1))
 * res0: Boolean = true
 */
public class P06 {

    public <T> boolean isPalindrome(List<T> list) {

        if (list.isEmpty()) {
            return true;
        }
        Utils.checkList(list);

        String listAsString = list.stream().map(Object::toString)
                .collect(Collectors.joining(","));

        String reveredAsString = list.stream().sorted((firstElement, secondElement) -> -1)
                .map(Object::toString)
                .collect(Collectors.joining(","));

        return listAsString.equals(reveredAsString);
    }

    @Test
    public void testIsPalindrome() {
        P06 t = new P06();

        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);
        Assert.assertTrue(t.isPalindrome(list));

        List<Integer> anotherList = Arrays.asList(1, 2, 3, 2, 1, 7);
        Assert.assertFalse(t.isPalindrome(anotherList));
    }
}
