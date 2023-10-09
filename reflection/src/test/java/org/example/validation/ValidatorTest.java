package org.example.validation;

import org.example.data.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void testValidationBlank() throws IllegalAccessException {
        Person person = new Person("Pablo","ichwan@test.com",0);
        Validator.validateNotBlank(person);
    }

}