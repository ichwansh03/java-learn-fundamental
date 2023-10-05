package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

    @Test
    void delayedJobTest() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);
        var future = executor.schedule(() -> System.out.println("delayed..."), 5, TimeUnit.SECONDS);

        var future2 = executor.scheduleWithFixedDelay(() -> System.out.println("delayed execution.."), 5000, 5000, TimeUnit.MILLISECONDS);

        System.out.println(future2.getDelay(TimeUnit.MILLISECONDS));

        //executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
    
    @Test
    void periodicJobTest() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);
        var future = executor.scheduleAtFixedRate(() -> System.out.println("delayed..."), 2, 2, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));

        //executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
