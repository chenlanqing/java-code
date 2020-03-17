package com.blue.fish.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class NormalObjectWeakReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWeakReference(NormalObject referent) {
        super(referent);
    }

    public NormalObjectWeakReference(NormalObject referent, ReferenceQueue<NormalObject> q) {
        super(referent, q);
        this.name = referent.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing NormalObjectWeakReference:" + name);
    }
}
