package org.example;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testCustomer() {

        Customer customer = new Customer("123B", "Pablo");

        customer.setId("123A");
        customer.setName("Ichwan");

        System.out.println(customer.getId() + " " + customer.getName());
        System.out.println(customer);
    }
}
