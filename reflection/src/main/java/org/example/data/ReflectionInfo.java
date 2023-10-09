package org.example.data;

import java.lang.annotation.*;

/**
 * Retention SOURCE digunakan untuk membuat java-docs
 */
@Documented
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReflectionInfo {
}
