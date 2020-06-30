package com.blue.fish.source.multi.inject;

import com.blue.fish.source.multi.ActivityProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author bluefish 2020-05-14
 * @version 1.0.0
 */
@Service("combine")
public class CombineActivityProcessor implements ActivityProcessor {
    @Override
    public void execute(ApplicationContext context) {

    }
}
