package com.blue.fish.spring.circle.setter;

/**
 * @author bluefish 2020-03-17
 * @version 1.0.0
 */
public class TestC {
    private TestA testA;

    public void c() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
