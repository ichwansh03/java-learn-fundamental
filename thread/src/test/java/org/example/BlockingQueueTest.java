package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void testArrayBlockingQueue() throws InterruptedException {
        final var queue = new ArrayBlockingQueue<String>(3);
        final var threads = Executors.newFixedThreadPool(12);

        for (int i = 0; i < 10; i++) {
            threads.execute(() ->{
                try {
                    queue.put("Put Data");
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threads.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("take data "+value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testLinkedBlockingQueue() throws InterruptedException {
        final var queue = new LinkedBlockingQueue<String>(3);
        final var threads = Executors.newFixedThreadPool(12);

        for (int i = 0; i < 10; i++) {
            threads.execute(() ->{
                try {
                    queue.put("Put Data");
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threads.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("take data "+value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testPriorityBlockingQueue() throws InterruptedException {
        final var queue = new PriorityBlockingQueue<Integer>(3, Comparator.reverseOrder());
        final var threads = Executors.newFixedThreadPool(12);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            threads.execute(() ->{
                queue.put(index);
                System.out.println("finish in-"+index);
            });
        }

        threads.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("take data "+value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testDelayedQueue() throws InterruptedException {
        final var queue = new DelayQueue<ScheduledFuture<String>>();
        final var threads = Executors.newFixedThreadPool(20);
        final var executorScheduled = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            queue.put(executorScheduled.schedule(() -> "Data "+index, i, TimeUnit.SECONDS));
        }

        threads.execute(() -> {
            while (true) {
                try {
                    var value = queue.take();
                    System.out.println("take data "+value.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    //ketika take data, baru datanya di get
    @Test
    void testSynchronousQueue() throws InterruptedException {
        final var queue = new SynchronousQueue<String>();
        final var threads = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            threads.execute(() ->{
                try {
                    queue.put("Data-"+index);
                    System.out.println("finish in "+index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threads.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("take data "+value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }

    /*
    * blockingDeque dapat diatur, bisa gunakan putFirst takeLast (LIFO), atau putFirst takeFirs (FIFO
    */
    @Test
    void testBlockingDeque() throws InterruptedException {
        final var queue = new LinkedBlockingDeque<String>();
        final var threads = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            try {
                queue.putLast("Data-"+index);
                System.out.println("finish in "+index);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        threads.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.takeFirst();
                    System.out.println("take data "+value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threads.awaitTermination(1, TimeUnit.MINUTES);
    }
}
