package net.gnejs.ref.provider.impl;

import aQute.bnd.annotation.component.Component;
import net.gnejs.ref.api.Transformer;

/**
 * Implements the transformer interface by reversing the string.
 * A null string will be transformed to null.
 */
@Component(immediate = true)
public class ReversedString implements Transformer {
    @Override
    public String transform(String input) {
        if (input == null) return null;
        else {
            return new StringBuilder(input).reverse().toString();
        }
    }
}
