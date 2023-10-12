package org.example;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidatorTest extends ValidateContract{

    @Test
    void methodValidationTest() throws NoSuchMethodException {

        Student student = new Student();
        String subject = "";

        Method method = student.getClass().getMethod("lesson", String.class);

        Set<ConstraintViolation<Student>> violations = executableValidator.validateParameters(student, method, new Object[]{subject});
        for (ConstraintViolation<Student> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());

            System.out.println(violation.getConstraintDescriptor());
            System.out.println(violation.getConstraintDescriptor().getAttributes());
            System.out.println(violation.getConstraintDescriptor().getGroups());
            System.out.println("++++++++");
        }
    }

    @Test
    void methodReturnValueValidationTest() throws NoSuchMethodException {

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
