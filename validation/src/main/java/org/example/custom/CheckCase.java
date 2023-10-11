package org.example.custom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CheckCaseValidator.class}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
