package com.blue.fish.common.annotation;

import java.lang.annotation.*;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NonThreadSafe {
}