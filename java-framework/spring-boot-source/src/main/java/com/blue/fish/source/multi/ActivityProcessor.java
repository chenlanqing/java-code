package com.blue.fish.source.multi;

import org.springframework.context.ApplicationContext;

/**
 * @author bluefish 2020-05-14
 * @version 1.0.0
 */
public interface ActivityProcessor {

    void execute(ApplicationContext context);
}
