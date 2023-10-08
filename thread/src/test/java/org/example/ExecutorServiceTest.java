package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    @Test
    void testSingleServiceExecutor() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("execute in thread "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testFixedServiceExecutor() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("execute in thread "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testWorkStealingServiceExecutor() throws InterruptedException {
        var executor = Executors.newWorkStealingPool(10);

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("execute in thread "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testCachedExecutor() throws InterruptedException {
        var executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("execute in thread "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
