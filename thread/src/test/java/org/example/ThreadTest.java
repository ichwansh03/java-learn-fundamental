package org.example;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void testThread(){
        var name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void testCreateThread(){
        Runnable runnable = () -> System.out.println("create new thread : "+Thread.currentThread().getName());

        var thread = new Thread(runnable);
        thread.start();

        var thread2 = new Thread(runnable);
        thread2.start();
    }

    @Test
    void testCreateThreadSleep() throws InterruptedException {

        System.out.println("load thread..");

        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("create new thread : "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var thread = new Thread(runnable);
        thread.start();

        thread.join();
        System.out.println("finish in thread "+thread.getName());
    }

    @Test
    void testSetThreadName(){
        var thread = new Thread(() -> {
            //RUNNABLE
            System.out.println(Thread.currentThread().getState());
            System.out.println("run in thread "+Thread.currentThread().getName());
        });

        thread.setName("Home");
        //NEW
        System.out.println(thread.getState());
        thread.start();
    }
}
