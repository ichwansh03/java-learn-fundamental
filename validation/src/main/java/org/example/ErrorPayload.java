package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class ErrorPayload implements Payload {

    public void sendInfo(ConstraintViolation<?> violation){
        System.out.println("Error : "+violation.getMessage());
    }
}
