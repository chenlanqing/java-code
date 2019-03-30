package com.blue.fish.se.basis.jmx.demo;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public class RMIClient {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, InvalidAttributeValueException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        ObjectName mbeanName = new ObjectName("jmxBean:name=hello");

        System.out.println("Domains ......");
        String[] domains = mbsc.getDomains();

        for (int i = 0; i < domains.length; i++) {
            System.out.println("doumain[" + i + "]=" + domains[i]);
        }
        System.out.println("MBean count = " + mbsc.getMBeanCount());

        mbsc.setAttribute(mbeanName, new Attribute("Name", "杭州"));
        mbsc.setAttribute(mbeanName, new Attribute("Age", "1990"));

        String age = (String) mbsc.getAttribute(mbeanName, "Age");
        String name = (String) mbsc.getAttribute(mbeanName, "Name");

        System.out.println("age=" + age + ";name=" + name);

        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, mbeanName, HelloMBean.class, false);

        proxy.helloWorld();
        proxy.helloWorld("BEST");
        proxy.getTelephone();
        //invoke调用bean的方法，只针对非设置属性的方法
        //例如invoke不能对getName方法进行调用
        mbsc.invoke(mbeanName, "getTelephone", null, null);
        mbsc.invoke(mbeanName, "helloWorld",
                new String[]{"I'll connect to JMX Server via client2"}, new String[]{"java.lang.String"});
        mbsc.invoke(mbeanName, "helloWorld", null, null);

    }
}
