package org.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBalanceTest {

    @Test
    void testBalances() throws NoSuchFieldException, IllegalAccessException {
        Balance balance = new Balance(100);
        ValidateBalance.validateBalance(balance);
    }
}