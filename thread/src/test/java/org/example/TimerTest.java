package org.example;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

//LOW LEVEL-RECOMMENDED TO DON'T USE THIS
public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {
        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("process delayed..");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 2000);

        Thread.sleep(3000);
    }

    @Test
    void periodicJob() throws InterruptedException {
        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("progress periodic..");
            }
        };

        var timer = new Timer();
        timer.schedule(task,1000,1000);

        Thread.sleep(5000);
    }
}
