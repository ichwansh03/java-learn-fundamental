package org.example.demo;

import java.lang.reflect.Field;

public class ValidateBalance {

    public static void validateBalance(Object object) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = object.getClass();

        Field balance = aClass.getDeclaredField("balance");

        BalanceValidator validator = balance.getAnnotation(BalanceValidator.class);

        if (validator != null) {
            balance.setAccessible(true);
            Object o = balance.get(object);

            if (o instanceof Integer){
                Integer balances = (Integer) o;

                if (balances < validator.min()) {
                    throw new RuntimeException("your balance is less than 50.000");
                } else if (balances > validator.max()) {
                    throw new RuntimeException("your balance is less than 2.000.000");
                }
            }
        }
    }
}
