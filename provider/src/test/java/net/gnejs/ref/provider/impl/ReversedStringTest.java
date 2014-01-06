package net.gnejs.ref.provider.impl;

import net.gnejs.ref.provider.impl.ReversedString;
import org.junit.Assert;
import org.junit.Test;

public class ReversedStringTest {
    @Test
    public void testThatNullIsTransformedToNull() {
        ReversedString reverser = new ReversedString();
        Assert.assertNull(reverser.transform(null));
    }

    @Test
    public void testThatStringIsReversed() {
        ReversedString reversed = new ReversedString();
        String input = "AbC";
        String expected = "CbA";
        Assert.assertEquals(expected, reversed.transform(input));
    }
}