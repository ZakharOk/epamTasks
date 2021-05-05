package com.epam.rd.java.basic.practice5;

public class Part3 {
    private final Thread[] threads;
    private final int numberOfIterations;

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.threads = new Thread[numberOfThreads];
        this.numberOfIterations = numberOfIterations;
    }

    private int counter;

    private int counter2;

    public static void main(final String[] args) {
        Part3 part3 = new Part3(3, 3);
        part3.compare();
        part3.reset();
        part3.compareSync();
    }

    public void reset() {
        counter = 0;
        counter2 = 0;
    }

    public void compare() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerNotSynchr();
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                t.interrupt();
            }
        }
    }

    public void compareSync() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerSynchr();
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                t.interrupt();
            }
        }
    }

    public synchronized void synchronizedPrint() {
        notSynchronizedPrint();
    }

    public void notSynchronizedPrint() {
        for (int i = 0; i < numberOfIterations; i++) {
            System.out.println(counter == counter2);
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            counter2++;
        }
    }

    private class WorkerNotSynchr extends Thread {

        @Override
        public void run() {
            notSynchronizedPrint();
            interrupt();
        }
    }

    private class WorkerSynchr extends Thread {

        @Override
        public void run() {
            synchronizedPrint();
            interrupt();
        }
    }

}

