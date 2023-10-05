package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private Integer value = 0;

    final private Lock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            value++;
        } finally {
            lock.unlock();
        }
    }

    public Integer getValue(){
        return value;
    }
}
