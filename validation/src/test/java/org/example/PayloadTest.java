package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.example.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends ValidateContract {

    @Test
    void testPayload() {

        Payment payment = new Payment();
        payment.setOrderId("P0001");
        payment.setAmount(35_000L);
        payment.setCreditCard("123456");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload){
                if (payloadClass == ErrorPayload.class){
                    ErrorPayload errorPayload = new ErrorPayload();
                    errorPayload.sendInfo(violation);
                }
            }
        }
    }
}
