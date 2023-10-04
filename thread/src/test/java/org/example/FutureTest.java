package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    @Test
    void testFuture() throws ExecutionException, InterruptedException {
        //var executor = Executors.newWorkStealingPool(5);
        var executor = Executors.newFixedThreadPool(5);

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "halo";
        };

        Future<String> future = executor.submit(callable);

        while (!future.isDone()){
            System.out.println("waiting...");
            Thread.sleep(1000);
        }

        String value = future.get();
        System.out.println(value);
    }
}
