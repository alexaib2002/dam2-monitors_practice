package org.dam.uem.relays;

public class RelayRace {

    public static int RUNNER_NUMBER = 4;

    public static synchronized void main(String[] args) {
        Runner[] runners = new Runner[RUNNER_NUMBER];
        for (int i = 0; i < RUNNER_NUMBER; i++) {
            runners[i] = new Runner(i);
            runners[i].start();
        }
        System.err.println("*** Runners have been created ***");
        for (int i = 0; i < RUNNER_NUMBER; i++) {
            while (runners[i].isAlive()) {
                synchronized(runners[i]) {
                    runners[i].notify();
                }
            }
        }
    }
}
