package com.blue.fish.design.pattern.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public class EmployeeFactory {

    private static final Map<String, Employee> EMPLOYEE_MAP = new ConcurrentHashMap<>();

    public static Employee getEmployee(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            System.out.print("创建部门经理:" + department + "\t");
            String reportContent = department + "部门汇报:此次报告的主要内容是......";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告:" + reportContent);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }
}
