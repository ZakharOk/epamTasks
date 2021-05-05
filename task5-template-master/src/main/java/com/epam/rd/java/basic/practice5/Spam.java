package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Spam {
    Thread[] threads;
    public Spam(final String[] messages, final int[] delays) {
        threads = new Thread[messages.length];
        for (int i =0;i<threads.length;i++) {
            threads[i] = new Thread(new Worker(messages[i],delays[i],false));
        }
    }

    public static void main(final String[] args) {
        }

    public void start() {
        for (Thread t: threads) {
            t.start();
        }
    }

    public void stop() {
        for (Thread t: threads) {
            t.interrupt();
        }
        threads=null;
    }

    private class Worker extends Thread {
        String msg;
        int delay;
        boolean exit;
        Logger logger;
        public Worker(String msg, int delay,boolean exit)
        {
            this.exit = exit;
            this.msg = msg;
            this.delay = delay;
        }
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(msg);
                    sleep(delay);
                    if (exit)
                        return;
                }
            } catch(NullPointerException e) {
                logger.severe("Thread NullPointer");
                }
             catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

        }
    }

}
