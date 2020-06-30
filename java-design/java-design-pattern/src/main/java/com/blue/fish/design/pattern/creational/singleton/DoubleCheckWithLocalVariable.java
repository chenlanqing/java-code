package com.blue.fish.design.pattern.creational.singleton;

/**
 * @author QingFan 2020-06-22
 * @version 1.0.0
 */
public class DoubleCheckWithLocalVariable {

    private volatile static DoubleCheckWithLocalVariable INSTANCE = null;

    private DoubleCheckWithLocalVariable() {
    }

    private static DoubleCheckWithLocalVariable getInstance() {
        DoubleCheckWithLocalVariable temp = INSTANCE;
        if (temp == null) {
            synchronized (DoubleCheckWithLocalVariable.class) {
                temp = INSTANCE;
                if (temp == null) {
                    temp = new DoubleCheckWithLocalVariable();
                    INSTANCE = temp;
                }
            }
        }
        return temp;
    }
}
