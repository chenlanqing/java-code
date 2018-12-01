package com.blue.fish.design.pattern.structural.proxy.proxyclass;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 调用下JDK中生成Class文件的方法，并且写入到本地文件，使用反编译工具查看代理生成的对象时什么样的
 *
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class CreateProxyClassTest {

    public static void main(String[] args) throws Exception{
        byte[] classFile = ProxyGenerator.generateProxyClass("TestProxy", new Class[]{TestInterface.class});
        File file = new File("temp/TestProxy.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(classFile);
        fos.flush();
        fos.close();
    }
}
// 生成的class文件
/**

 import com.blue.fish.design.pattern.structural.proxy.proxyclass.TestInterface;
 import java.lang.reflect.InvocationHandler;
 import java.lang.reflect.Method;
 import java.lang.reflect.Proxy;
 import java.lang.reflect.UndeclaredThrowableException;

 public final class TestProxy extends Proxy implements TestInterface {
 private static Method m1;
 private static Method m2;
 private static Method m5;
 private static Method m4;
 private static Method m3;
 private static Method m0;

 public TestProxy(InvocationHandler var1) throws  {
 super(var1);
 }

 public final boolean equals(Object var1) throws  {
 try {
 return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
 } catch (RuntimeException | Error var3) {
 throw var3;
 } catch (Throwable var4) {
 throw new UndeclaredThrowableException(var4);
 }
 }

 public final String toString() throws  {
 try {
 return (String)super.h.invoke(this, m2, (Object[])null);
 } catch (RuntimeException | Error var2) {
 throw var2;
 } catch (Throwable var3) {
 throw new UndeclaredThrowableException(var3);
 }
 }

 public final void method3() throws  {
 try {
 super.h.invoke(this, m5, (Object[])null);
 } catch (RuntimeException | Error var2) {
 throw var2;
 } catch (Throwable var3) {
 throw new UndeclaredThrowableException(var3);
 }
 }

 public final void method2() throws  {
 try {
 super.h.invoke(this, m4, (Object[])null);
 } catch (RuntimeException | Error var2) {
 throw var2;
 } catch (Throwable var3) {
 throw new UndeclaredThrowableException(var3);
 }
 }

 public final void method1() throws  {
 try {
 super.h.invoke(this, m3, (Object[])null);
 } catch (RuntimeException | Error var2) {
 throw var2;
 } catch (Throwable var3) {
 throw new UndeclaredThrowableException(var3);
 }
 }

 public final int hashCode() throws  {
 try {
 return (Integer)super.h.invoke(this, m0, (Object[])null);
 } catch (RuntimeException | Error var2) {
 throw var2;
 } catch (Throwable var3) {
 throw new UndeclaredThrowableException(var3);
 }
 }

 static {
 try {
 m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
 m2 = Class.forName("java.lang.Object").getMethod("toString");
 m5 = Class.forName("com.blue.fish.design.pattern.structural.proxy.proxyclass.TestInterface").getMethod("method3");
 m4 = Class.forName("com.blue.fish.design.pattern.structural.proxy.proxyclass.TestInterface").getMethod("method2");
 m3 = Class.forName("com.blue.fish.design.pattern.structural.proxy.proxyclass.TestInterface").getMethod("method1");
 m0 = Class.forName("java.lang.Object").getMethod("hashCode");
 } catch (NoSuchMethodException var2) {
 throw new NoSuchMethodError(var2.getMessage());
 } catch (ClassNotFoundException var3) {
 throw new NoClassDefFoundError(var3.getMessage());
 }
 }
 }
 */
