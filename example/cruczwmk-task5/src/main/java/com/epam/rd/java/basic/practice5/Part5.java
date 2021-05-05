package com.epam.rd.java.basic.practice5;

import java.io.*;
import java.util.logging.Logger;

public class Part5 implements Runnable {
    Logger logger;
    static int counter = 0;
    Thread[] threads;
    Part5()
    {
        threads = new Thread[10];
        for(int i = 0; i<threads.length; i++)
        {
            threads[i] = new Thread(this);
        }
    }
    public static void main(final String[] args) {
       Part5 p = new Part5();
       p.runThreads();
    }
    void runThreads()
    {
        for (Thread t: threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                t.interrupt();
            }
        }
    }
    void writeData(int lineToWrite, String field)
    {
        File f = new File("part5.txt");
        StringBuilder data = new StringBuilder();
        for (int i = 0; i< 20;i++) {
            data.append(field);
        }
        System.out.println(data.toString().trim());
        int bytesPerLine = 20 +2;
        try (RandomAccessFile r = new RandomAccessFile(f,"rw")) {
                long whereToWrite;
                if (lineToWrite == -1) {
                    whereToWrite = r.length();
                } else {
                    whereToWrite = bytesPerLine * (long) lineToWrite;
                }
                r.seek(whereToWrite);
                r.write(data.toString().getBytes());
                r.writeBytes(System.lineSeparator());
        } catch (IOException e) {
            logger.severe("FileNotFound");
        }
    }
    String readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("part5.txt"))) {
                while (br.ready()) {
                    sb.append(br.readLine()).append(System.lineSeparator());
                }
            }
        } catch (FileNotFoundException e) {
            logger.severe("FileNotFound");
        }
        return sb.toString().trim();
    }
    static void increment()
    {
        counter++;
    }
    @Override
    public void run() {

        try {
                writeData(counter, "" + counter);
                Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        increment();
    }
}
