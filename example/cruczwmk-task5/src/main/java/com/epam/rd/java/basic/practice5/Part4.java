package com.epam.rd.java.basic.practice5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class Part4 {
    Logger log;
    private static final int ROWS = 4;
    private static final int COLS = 100;
    private final Integer[][] matrix;

    public Part4() {
        matrix = getMatrix();
    }

    private Integer[][] getMatrix() {
        Integer[][] out = new Integer[ROWS][COLS];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("part4.txt")))) {
            for (int i = 0; i < ROWS; i++) {
                String[] strArr = reader.readLine().trim().split(" ");
                for (int j = 0; j < COLS; j++) {
                    out[i][j] = Integer.parseInt(strArr[j]);
                }
            }
        } catch (IOException e) {
            log.severe("IOException");
        }
        return out;
    }

    private void findMaxPar() {
        long start = System.currentTimeMillis();
        List<Future<Integer>> fs = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(ROWS);
        for (int i = 0; i < ROWS; i++) {
            fs.add(service.submit(new Helper(matrix[i])));
        }
        service.shutdown();
        try {
            int max = 0;
            for(Future<Integer> f : fs) {
                int tmp = f.get();
                max = Math.max(max, tmp);
            }
            System.out.println(max);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private void findMax() {
        long start = System.currentTimeMillis();
        int max = matrix[0][0];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                max = Math.max(max, matrix[i][j]);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println(max);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static class Helper implements Callable<Integer> {
        Integer[] arr;

        Helper(Integer[] arr) {
            this.arr = arr;
        }

        @Override
        public Integer call() {
            int max = arr[0];
            for (int i = 0; i < COLS; i++) {
                max = Math.max(max, arr[i]);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return max;
        }
    }

    public static void main(final String[] args) {
        Part4 p4 = new Part4();
        p4.findMaxPar();
        p4.findMax();
    }
}
