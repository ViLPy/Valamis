package com.arcusys.learn.AopTest;

import java.lang.annotation.*;

/**
 * Created by Iliya on 05.02.14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AopAnnotation {
}
