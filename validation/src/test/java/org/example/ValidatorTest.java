package org.example;

import jakarta.validation.ConstraintViolationException;
import org.example.group.*;
import org.junit.jupiter.api.*;

public class ValidatorTest extends ValidateContract {

    @Test
    void testConstrainValidation(){
        Student student = new Student();

        validate(student);
    }

    @Test
    void testConstrainValidationException(){

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Student student = new Student();
            validateWithException(student);
        });
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
        payment.setAmount(1000L);
        payment.setOrderId("O0001");
        payment.setCreditCard("123");

        validate(payment);
    }

    @Test
    void testValidationGroups(){
        Payment payment = new Payment();
        payment.setAmount(100L);
        payment.setOrderId("AIAA");
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

    @Test
    void testRegister(){
        Register register = new Register();
        register.setUsername("Hai");
        register.setPassword("123");
        register.setConfirmPassword("1234");

        validate(register);
    }
}
