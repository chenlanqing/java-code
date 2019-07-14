package com.blue.fish.se.basis.string;

public class StringBufferTest {
    public void append() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");
    }

    public static void main(String[] args) {
        new StringBufferTest().append();
    }
}