package com.blue.fish.spring.circle.constructor;

/**
 * @author bluefish 2020-03-17
 * @version 1.0.0
 */
public class TestB {
    private TestC testC;

    public TestB(TestC testC) {
        this.testC = testC;
    }

    public void b() {
        testC.c();
    }

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
