package org.dam.uem.relays;

public class Runner extends Thread {
    public static long MAX_TIME = 5l;
    private int runnerId;

    public Runner(int runnerId) {
        this.runnerId = runnerId;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Runner %s, waiting to run\n", runnerId);
            synchronized (this) {
                wait();
            }
            System.out.printf("%s is running now!\n", runnerId);
            Thread.sleep((long) (Math.random() * MAX_TIME * 1000));
            System.out.printf("%s has finished their run\n", runnerId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}