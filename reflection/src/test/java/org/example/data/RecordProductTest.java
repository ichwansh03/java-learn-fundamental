package org.example.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordProductTest {

    @Test
    void testRecordProduct() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Product> productClass = Product.class;

        System.out.println(Arrays.toString(productClass.getRecordComponents()));

        Method name = productClass.getDeclaredMethod("name");
        Product product = new Product("P001","Minyak",12000L);
        System.out.println(name.invoke(product));

        RecordComponent[] recordComponents = productClass.getRecordComponents();
        for (RecordComponent component : recordComponents){
            Method accessor = component.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
        }
    }
}
