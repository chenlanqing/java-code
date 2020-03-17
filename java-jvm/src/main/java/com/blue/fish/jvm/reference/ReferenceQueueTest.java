package com.blue.fish.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class ReferenceQueueTest {

    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> ref = null;

        while ((ref = (Reference<NormalObject>) rq.poll()) != null) {
            if (ref != null) {
                System.out.println("in queue:" + ((NormalObjectWeakReference) ref).name);
                System.out.println("reference object : " + ref.get());
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ArrayList<WeakReference<NormalObject>> weakList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            weakList.add(new NormalObjectWeakReference(new NormalObject("weak" + i), rq));
            System.out.println("create weak:" + weakList.get(i));
        }

        System.out.println("first time");

        checkQueue();

        System.gc();

        Thread.sleep(1000);

        System.out.println("second time");

        checkQueue();
    }
}
