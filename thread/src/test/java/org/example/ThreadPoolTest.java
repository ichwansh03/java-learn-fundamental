package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    @Test
    void threadPoolExecutorTest() throws InterruptedException {

        var queue = new ArrayBlockingQueue<Runnable>(100);
        var threadPool = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, queue);

        threadPool.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("runnable from thread "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(4000);
    }

    @Test
    void shutdownThreadTest() throws InterruptedException {
        var queue = new ArrayBlockingQueue<Runnable>(100);
        var threadPool = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, queue);

        for (int i = 0; i < 100; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("task "+task+" from thread "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            threadPool.execute(runnable);
        }

        //langsung hentikan ketika dieksekusi
        //threadPool.shutdown();

        //menunggu eksekusi hingga timeout
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
