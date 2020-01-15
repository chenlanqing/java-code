package com.blue.fish.source.properties;

import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-01-15
 * @version 1.0.0
 */
@Component
public class CustomFlag {

    private String name = "Custom Flag";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


