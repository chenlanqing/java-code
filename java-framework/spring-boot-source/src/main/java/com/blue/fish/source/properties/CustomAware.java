package com.blue.fish.source.properties;

import org.springframework.beans.factory.Aware;

/**
 * @author bluefish 2020-01-15
 * @version 1.0.0
 */
public interface CustomAware extends Aware {

    void setCustomFlag(CustomFlag flag);
}
