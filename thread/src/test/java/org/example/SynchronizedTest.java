package org.example;

import org.junit.jupiter.api.Test;

//LOW LEVEL-RECOMMENDED TO DON'T USE THIS
public class SynchronizedTest {

    @Test
    void testSynchronizedCounter() throws InterruptedException{
        var counter = new SynchronizedCounter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }
}
