package com.blue.fish.spring.circle.setter;

/**
 * @author bluefish 2020-03-17
 * @version 1.0.0
 */
public class TestA {

    private TestB testB;

    public void a(){
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
