package org.example;

import org.junit.jupiter.api.Test;

//LOW LEVEL-RECOMMENDED TO DON'T USE THIS
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

    //case dimana thread saling bergantung dengan thread lain
    private String message = null;

    @Test
    void testThreadCommunication() throws InterruptedException {
        //untuk nge-lock thread saja
        final var lock = "";

        //pastikan method wait() diexecute duluan
        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Open communication with thread1";
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
