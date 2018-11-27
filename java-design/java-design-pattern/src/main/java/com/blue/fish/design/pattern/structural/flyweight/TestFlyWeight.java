package com.blue.fish.design.pattern.structural.flyweight;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public class TestFlyWeight {
    private static final String departments[] = {"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            String department = departments[(int)(Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getEmployee(department);
            manager.report();

        }
    }

}
