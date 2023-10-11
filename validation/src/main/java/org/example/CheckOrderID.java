package org.example;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.custom.CaseMode;
import org.example.custom.CheckCase;
import org.example.custom.CheckCaseValidator;
import org.example.group.CreditCardPaymentGroup;
import org.example.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class} ,message = "order id can't blank")
@Size(min = 1, max = 10, message = "Order ID must between {min} and {max}")
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckOrderID {

    String message() default "invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
