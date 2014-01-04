package net.gnejs.ref.consumer.impl;

import net.gnejs.ref.api.Transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caller {
    private final List<Transformer> knownTransformers = Collections.synchronizedList(new ArrayList<Transformer>());
    private final String inputString;
    private final Callback callback;


    public Caller(String inputString, Callback callback) {
        this.inputString = inputString;
        this.callback = callback;
    }

    private String callTransformers() {
        String result = inputString;
        for (Transformer transformer : knownTransformers) {
            result = transformer.transform(result);
        }
        return result;
    }

    void addTransformer(Transformer transformer) {
        knownTransformers.add(transformer);
        callback.transformed(callTransformers());
    }
    void removeTransformer(Transformer transformer) {
        knownTransformers.remove(transformer);
    }

    interface Callback {
        void transformed(String transformation);
    }
}