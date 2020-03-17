package com.blue.fish.jvm.classloader;

/**
 * @author bluefish 2019-03-04
 * @version 1.0.0
 */
public class UnsafeTest {

    public static void main(String args[]) throws Throwable {
//        Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        Unsafe unsafe = (Unsafe) f.get(null);
//        String filePath = "/Users/nijiaben/AA.class";
//        byte[] buffer = getFileContent(filePath);
//        Class<?> c1 = unsafe.defineAnonymousClass(UnsafeTest.class, buffer, null);
//        Class<?> c2 = unsafe.defineAnonymousClass(UnsafeTest.class, buffer, null);
//        System.out.println(c1 == c2);

        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println("Main.class.getClassLoader()：" + UnsafeTest.class.getClassLoader());
        System.out.println(UnsafeTest.class.getClassLoader().getParent());
        Class.forName("com.blue.fish.jvm.classloader.UnsafeTest", true, UnsafeTest.class.getClassLoader().getParent());//抛出异常
    }
}
