package org.example;

import jakarta.validation.*;
import org.example.group.CreditCardPaymentGroup;
import org.example.group.PaymentGroupSequence;
import org.example.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.*;
import java.util.Set;

public class ValidatorTest {

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
    void testConstrainValidation(){
        Student student = new Student();

        Set<ConstraintViolation<Student>> validate = validator.validate(student);
        Assertions.assertEquals(2, validate.size());

        for (ConstraintViolation<Student> violations : validate) {
            System.out.println(violations.getMessage());
            System.out.println(violations.getLeafBean());
            System.out.println(violations.getConstraintDescriptor().getAttributes());
            System.out.println(violations.getConstraintDescriptor().getAnnotation());
            System.out.println(violations.getInvalidValue());
        }
    }

    @Test
    void testNestedValidation(){
        Student student = new Student();
        student.setName("Ichwan Sholihin");
        student.setNip("19312131");

        Address address = new Address();
        student.setAddress(address);

        validate(student);
    }

    @Test
    void testHibernateConstraintValidator(){
        Payment payment = new Payment();
        payment.setAmount(100000L);
        payment.setOrderId("O0001");
        payment.setCreditCard("123");

        validate(payment);
    }

    @Test
    void testValidationGroups(){
        Payment payment = new Payment();
        payment.setAmount(100000L);
        payment.setOrderId("O0001");
        payment.setCreditCard("123");
        payment.setVirtualAccount("123");

        //validateWithGroups(payment, CreditCardPaymentGroup.class);
        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }

    @Test
    void testValidationGroupSequence(){
        Payment payment = new Payment();
        payment.setAmount(100000L);
        payment.setOrderId("O0001");
        payment.setCreditCard("123");
        payment.setVirtualAccount("123");

        validateWithGroups(payment, PaymentGroupSequence.class);
    }

    @Test
    void testGroupConvert(){
        Payment payment = new Payment();
        payment.setAmount(100000L);
        payment.setOrderId("O0001");
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    void validate(Object o){
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("++++++++");
        }
    }

    void validateWithGroups(Object o, Class<?>... classes){
        Set<ConstraintViolation<Object>> violations = validator.validate(o, classes);
        for (ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("++++++++");
        }
    }
}
