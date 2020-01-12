package com.blue.fish.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSourceApplication {

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(SpringBootSourceApplication.class);
//        application.addInitializers(new SecondInitializer());
//
//        application.run(args);
        SpringApplication.run(SpringBootSourceApplication.class, args);
    }
}
