package com.epam.rd.java.basic.practice5;

import java.util.Scanner;
import java.util.logging.Logger;

public class Spam {
    Thread[] threads;
    String[] messages;
    int[] delays;
    public Spam(final String[] messages, final int[] delays) {
        threads = new Thread[messages.length];
        this.messages = messages;
        this.delays = delays;
        for (int i =0;i<threads.length;i++) {
            threads[i] = (new Worker(messages[i],delays[i]));
        }
    }

    public static void main(final String[] args) {
        Spam s = new Spam(new String[] { "@@@", "bbbbbbb" },new int[] { 222, 333 });
        s.start();
            if(new Scanner(System.in).nextLine().equals(""))
            {
                s.stop();
            }

    }

    public void start() {
        for (Thread t: threads) {
            t.start();
        }
    }

    public void stop() {
        for (Thread t: threads) {
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                t.interrupt();
            }
        }
    }

    private static class Worker extends Thread {
        String msg;
        int delay;
        Logger logger;

        public Worker(String msg, int delay)
        {
            this.msg = msg;
            this.delay = delay;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    System.out.println(msg);
                    sleep(delay);
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
