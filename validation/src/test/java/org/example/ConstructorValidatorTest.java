package org.example;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidatorTest extends ValidateContract {

    @Test
    void testValidationConstructorStudent() throws NoSuchMethodException {
        String name = "";
        String nip = "";
        Address address = new Address();

        Constructor<Student> constructor = Student.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Student>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{name, nip, address});

        for (ConstraintViolation<Student> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("--------------");
        }
    }

    @Test
    void testValidationConstructorReturnValueStudent() throws NoSuchMethodException {
        String name = "";
        String nip = "";
        Address address = new Address();

        Student student = new Student(name, nip, address);

        Constructor<Student> constructor = Student.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Student>> violations = executableValidator.validateConstructorReturnValue(constructor, student);

        for (ConstraintViolation<Student> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("--------------");
        }
    }
}
