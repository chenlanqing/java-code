package com.blue.fish.source.properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-01-15
 * @version 1.0.0
 */
@Component
public class ResultCommandLineRunner implements CommandLineRunner, EnvironmentAware, CustomAware {

    private Environment environment;

    private CustomFlag customFlag;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(environment.getProperty("test.url"));
//        System.out.println(customFlag.getName());
//
//        System.out.println(environment.getProperty("mooc.defalut.name"));

        System.out.println(environment.getProperty("banner.tag"));

        System.out.println(environment.getProperty("jdbc.url"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setCustomFlag(CustomFlag flag) {
        this.customFlag = flag;
    }
}
