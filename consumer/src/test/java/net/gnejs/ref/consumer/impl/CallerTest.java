package net.gnejs.ref.consumer.impl;

import net.gnejs.ref.api.Transformer;
import org.junit.Assert;
import org.junit.Test;

public class CallerTest {

    class MockCallback implements Caller.Callback {
        private String result = null;
        @Override
        public void transformed(String transformation) {
            result = transformation;
        }

        public String getResult() {
            return result;
        }
    }

    class Multiplier implements Transformer {
        @Override
        public String transform(String input) {
            if (input == null) return null;
            else {
                return input + input;
            }
        }
    }

    @Test
    public void testNoTransformer() {
        MockCallback callback = new MockCallback();
        Caller caller = new Caller("ABC", callback);
        Assert.assertNull(callback.getResult());

    }

    @Test
    public void testOneTransformer() {
        MockCallback callback = new MockCallback();
        Caller caller = new Caller("ABC", callback);
        caller.addTransformer(new Multiplier());
        Assert.assertEquals("ABCABC", callback.getResult());
    }

    @Test
    public void testTwoTransformers() {
        MockCallback callback = new MockCallback();
        Caller caller = new Caller("ABC", callback);
        caller.addTransformer(new Multiplier());
        caller.addTransformer(new Multiplier());
        Assert.assertEquals("ABCABCABCABC", callback.getResult());
    }

}
