package com.epam.rd.java.basic.practice5;


import java.util.logging.Logger;

public class Part1 extends Thread {
    Logger logger;
    public static void main(String[] args) {
        Part1 p = new Part1();
        Part1 p1 = new Part1();
        try {
            p.start();
            p.join();
            p1.start();
            p1.join();
        } catch (InterruptedException e) {
            p.logger.severe("Interrupted ex");
            p.interrupt();
            p1.interrupt();
        }
        }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(currentThread().getName());
                sleep(500);
            }
            currentThread().interrupt();
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }
}

