package com.blue.fish.jvm.reference;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class FinalizerDemo {

    private static FinalizerDemo finalizerDemo;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalized");
        finalizerDemo = this;
    }

    public static void main(String[] args) throws Exception{
        FinalizerDemo f = new FinalizerDemo();
        System.out.println("First : " + f);
        f = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println("Second : " + f);

        System.out.println(finalizerDemo);

    }
}
