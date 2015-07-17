package com.landsmann.probs.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * P31 (**) Determine whether a given integer number is prime.
 * scala> 7.isPrime
 * res0: Boolean = true
 */
public class P31 {

    public boolean isPrime(int i) {
        return !IntStream.range(2, i - 1).anyMatch(t -> (i % t) == 0);
    }

    @Test
    public void testIsPrime() {
        P31 t = new P31();
        Assert.assertTrue(t.isPrime(7));
        Assert.assertFalse(t.isPrime(8));
    }
}
