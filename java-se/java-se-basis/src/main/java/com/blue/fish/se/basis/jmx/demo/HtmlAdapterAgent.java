package com.blue.fish.se.basis.jmx.demo;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * 通过JMX提供的工具页访问
 *
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public class HtmlAdapterAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        String domainName = "jmxBean";

        ObjectName helloName = new ObjectName(domainName + ":name=hello");

        server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        adapter.start();
    }
}
