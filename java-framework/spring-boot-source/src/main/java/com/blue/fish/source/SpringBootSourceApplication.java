package com.blue.fish.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class SpringBootSourceApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootSourceApplication.class);
//        application.addInitializers(new SecondInitializer());
//        application.addListeners(new SecondListener());
        Properties properties = new Properties();
        properties.put("test.url", "www.test.com");
        application.setDefaultProperties(properties);
        application.run(args);
//        SpringApplication.run(SpringBootSourceApplication.class, args);
    }
}
