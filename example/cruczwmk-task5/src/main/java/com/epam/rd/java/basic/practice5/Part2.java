package com.epam.rd.java.basic.practice5;

import java.io.InputStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Part2 {

    public static void main(final String[] args) {
        System.setIn( new Read());
        Thread t = new Thread(() -> Spam.main(null));
        t.start();
        try {
            t.join();
            System.setIn(System.in);
        } catch (InterruptedException e) {
            t.interrupt();
        }

    }
    public static class Read extends InputStream {
        boolean firstInit = true;
        @Override
        public int read() {

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
            if(firstInit) {
                firstInit = false;
                return 10;
            }
            return -1;
        }
        @Override
        public int read(byte[] b,int i,int a) {
                b[0] = (byte) read();
            return 1;
        }
    }
    }
