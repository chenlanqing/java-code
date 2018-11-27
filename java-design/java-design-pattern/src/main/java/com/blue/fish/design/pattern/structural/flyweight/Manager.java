package com.blue.fish.design.pattern.structural.flyweight;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public class Manager implements Employee{
    // 内部状态，共享的
    private String title = "部门经理";
    // 外部状态
    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }
}
