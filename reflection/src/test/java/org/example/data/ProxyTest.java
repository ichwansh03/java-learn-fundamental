package org.example.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testProxyInterfaceCar(){

        InvocationHandler handler = (proxy, method, args) -> {

            if (method.getName().equals("getDrive")){
                return "Driver is yours";
            }

            if (method.getName().equals("run")) {
                System.out.println("Car is run");
            }
            return null;
        };

        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Car.class}, handler);

        System.out.println(car.getClass());
        System.out.println(car.getDrive());
        car.run();
    }
}
