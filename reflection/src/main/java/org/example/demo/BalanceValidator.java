package org.example.demo;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface BalanceValidator {

    int min() default 50;
    int max() default 200;

}
