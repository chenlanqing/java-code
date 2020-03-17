package com.blue.fish.jvm.reference;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class NormalObject {

    public String name;

    public NormalObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("NormalObject Finalizing Object: " + name);
    }
}
