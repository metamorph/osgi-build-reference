package net.gnejs.ref.provider;

import net.gnejs.ref.api.Transformer;

/**
 * Implements the transformer interface by reversing the string.
 * A null string will be transformed to null.
 */
public class ReversedString implements Transformer {
    @Override
    public String transform(String input) {
        if (input == null) return null;
        else {
            return new StringBuilder(input).reverse().toString();
        }
    }
}
