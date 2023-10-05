package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ForkJoinTest {

    @Test
    void testForkJoin(){
        var forkJoinPool1 = ForkJoinPool.commonPool();
        var forkJoinPool2 = new ForkJoinPool(5);

        var executor = Executors.newWorkStealingPool(5);
    }

    public static class SimpleForkJoinTask extends RecursiveAction {

        private final List<Integer> integers;

        public SimpleForkJoinTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {
            if (integers.size() <= 10){
                executes();
            } else {
                forkCompute();
            }
        }

        private void forkCompute() {
            List<Integer> integers1 = this.integers.subList(0, this.integers.size()/3);
            SimpleForkJoinTask task1 = new SimpleForkJoinTask(integers1);

            List<Integer> integers2 = this.integers.subList(0, this.integers.size()/3);
            SimpleForkJoinTask task2 = new SimpleForkJoinTask(integers2);

            List<Integer> integers3 = this.integers.subList(0, this.integers.size()/3);
            SimpleForkJoinTask task3 = new SimpleForkJoinTask(integers3);

            ForkJoinTask.invokeAll(task1, task2, task3);
        }

        private void executes() {
            integers.forEach(integer -> {
                System.out.println(Thread.currentThread().getName() + ":" + integer);
            });
        }

    }

    @Test
    void testRecursiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> integers = IntStream.range(0, 99).boxed().toList();

        var task = new SimpleForkJoinTask(integers);
        pool.execute(task);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
