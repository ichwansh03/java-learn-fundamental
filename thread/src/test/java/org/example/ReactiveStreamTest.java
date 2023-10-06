package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class ReactiveStreamTest {

    @Test
    void sendFromPublisher() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>();
        var subscriber = new PrintSubscriber("Subs1",2000L);
        var subscriber2 = new PrintSubscriber("Subs2",1000L);
        publisher.subscribe(subscriber);
        publisher.subscribe(subscriber2);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(() ->{
            //default dari buffer size adalah 256 threads
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(2000);
                    publisher.submit("Data-"+i);
                    System.out.println(Thread.currentThread().getName()+" send: "+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    public static class PrintSubscriber implements Flow.Subscriber<String>{

        private Flow.Subscription subscription;

        private String name;
        private Long sleep;

        public PrintSubscriber(String name, Long sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        //infinite loop from onSubscribe to onNext
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(sleep);
                System.out.println("Process on : "+Thread.currentThread().getName()+" : "+name+" item");
                this.subscription.request(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName()+" complete");
        }
    }



    @Test
    void processor() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>();

        var processor = new WorkProcessor();
        publisher.subscribe(processor);

        var subscriber = new PrintSubscriber("Processor",1000L);
        processor.subscribe(subscriber);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(() ->{
            //default dari buffer size adalah 256 threads
            for (int i = 0; i < 50; i++) {
                publisher.submit("Data-"+i);
                System.out.println(Thread.currentThread().getName()+" send: "+i);
            }
        });

        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

    public static class WorkProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            var value = "hello "+item;
            submit(value);
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            close();
        }
    }

}
