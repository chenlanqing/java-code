package com.blue.fish.se.basis.jmx.demo;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * 通过客户端程序进行远程访问
 *
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public class RMIAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        String domainName = "jmxBean";

        ObjectName helloName = new ObjectName(domainName + ":name=hello");

        server.registerMBean(new Hello(), helloName);

        try {
            // 注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
            LocateRegistry.createRegistry(9999);
            // URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url ,null, server);
            System.out.println("begin rmi start");
            jcs.start();

            System.out.println("rmi start");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
