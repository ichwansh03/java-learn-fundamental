package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SynchronizerTest {

    @Test
    void testSemaphore() throws InterruptedException {
        //jumlah thread yg diizinkan per execute
        final var semaphore = new Semaphore(5);
        final var executor = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 100; i++) {
            executor.execute(() ->{
                try {
                    //thread dihold menggunakan acquire
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Progress..");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    //release jika sudah selesai
                    semaphore.release();
                    System.out.println("Release");
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testExchanger() throws InterruptedException {

        final var exchanger = new Exchanger<String>();
        final var threads = Executors.newFixedThreadPool(10);

        threads.execute(() -> {
            try {
                System.out.println("Send from Thread 1");
                Thread.sleep(1000);
                var result = exchanger.exchange("thread2");
                System.out.println("receive from thread 1 "+result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threads.execute(() -> {
            try {
                System.out.println("Send from Thread 2");
                Thread.sleep(2000);
                var result = exchanger.exchange("thread1");
                System.out.println("receive from thread 2 "+result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    //aman digunakan ketika diakses pada multiple thread
    @Test
    void testConvertListToSynchronized(){
        List<String> names = List.of("Ichwan","Sholihin","Ahmad");
        Collections.synchronizedList(names);

    }
}
