package net.gnejs.ref.consumer.impl;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;
import net.gnejs.ref.api.Transformer;

@Component(provide = {})
public class CallerComponent implements Caller.Callback {

    public static final String INPUT = "ABCdef";
    private Caller delegate;

    @Reference(multiple = true)
    public void addTransformer(Transformer tf) {
        delegate.addTransformer(tf);
    }
    public void removeTransformer(Transformer tf) {
        delegate.removeTransformer(tf);
    }

    @Activate
    public void activate() {
        System.out.println("Activating");
        delegate = new Caller(INPUT, this);
    }

    @Deactivate
    public void deactivate() {
        System.out.println("Deactivating");
        delegate = null;
    }

    @Override
    public void transformed(String transformation) {
        System.out.println("Transformed String: " + transformation);
    }
}
