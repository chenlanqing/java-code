package com.blue.fish.se.basis.jmx.demo;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * 通过jconsole
 *
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public class JConsoleAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        String domainName = "jmxBean";

        ObjectName helloName = new ObjectName(domainName + ":name=hello");

        server.registerMBean(new Hello(), helloName);

        Thread.sleep(60 * 60 * 1000);
    }
}
