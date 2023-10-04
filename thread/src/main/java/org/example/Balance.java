package org.example;

public class Balance {

    private Long value;

    public Balance(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public static void transfer(Balance from, Balance to, Long value) throws InterruptedException {
        /*
        * Thread A melakukan lock from nya, Thread B melakukan lock to nya, ketika sleep() dari Thread A sudah selesai
        * Thread B sudah keburu eksekusi lock to nya dan ketika Thread B akses ke lock from, maka lock from sudah di lock oleh Thread A
        *
        synchronized (from){
            Thread.sleep(1000);
            synchronized (to){
                Thread.sleep(1000);
                from.setValue(from.getValue() - value);
                to.setValue(to.getValue() + value);
            }
        }*/

        synchronized (from){
            Thread.sleep(1000);
            from.setValue(from.getValue() - value);
        }

        synchronized (to){
            Thread.sleep(1000);
            to.setValue(to.getValue() + value);
        }
    }
}
