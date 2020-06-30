package com.blue.fish.source.multi;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author bluefish 2020-05-14
 * @version 1.0.0
 */
@Component
public class ActivityProcessorFactory {

    @Resource
    private Map<String, ActivityProcessor> activityProcessor;

    @PostConstruct
    private void init() {
        System.out.println(activityProcessor);
    }

}
