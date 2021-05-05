package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;


public class Part1 extends Thread {
    Logger log;


    public static void main(String[] args) {
        Logger l1 = null;
        Part1 p = new Part1();
        Part1 p2 = new Part1();
        try {
            p.start();
            p.join();
            p2.start();
        } catch (Exception e) {
            assert false;
            l1.severe("main issue");
        }
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(currentThread().getName());
                sleep(500);
            }
        } catch (Exception e) {
            log.severe("Interrupted Thread");
        }
    }
}
