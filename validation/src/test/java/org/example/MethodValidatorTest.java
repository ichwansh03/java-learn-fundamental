package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidatorTest {

    private ValidatorFactory factory;
    private Validator validator;

    @BeforeEach
    void setUp(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterEach
    void tearDown(){
        factory.close();
    }

    @Test
    void methodValidationTest() throws NoSuchMethodException {

        ExecutableValidator executableValidator = validator.forExecutables();

        Student student = new Student();
        String subject = "Ahmad";

        Method method = student.getClass().getMethod("lesson", String.class);

        Set<ConstraintViolation<Student>> violations = executableValidator.validateParameters(student, method, new Object[]{subject});
        for (ConstraintViolation<Student> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());
            System.out.println("++++++++");
        }
    }

    @Test
    void methodReturnValueValidationTest() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        Student student = new Student();

        String classCode = student.classCode();

        Method method = student.getClass().getMethod("classCode");

        Set<ConstraintViolation<Student>> violations = executableValidator.validateReturnValue(student, method, classCode);
        for (ConstraintViolation<Student> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());
            System.out.println("++++++++");
        }
    }
}
