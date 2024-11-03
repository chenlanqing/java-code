package com.qing.fan.common.annotations;

import java.lang.annotation.*;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月03日 16:37
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ThreadSafe {
}
