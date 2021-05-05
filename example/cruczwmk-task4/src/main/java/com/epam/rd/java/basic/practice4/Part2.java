package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Part2 {
    static Logger log = Logger.getLogger(Part2.class.getName());
    public static void main(String[] args){
        try {
            System.out.println("input ==> "+readText());
            System.out.println("output ==> "+sorting());
        } catch (IOException e) {
            Part2.log.severe(e.getMessage());
        }
    }
    public static String sorting() throws IOException {
        File f = new File("part2_sorted.txt");
        StringBuilder sb;
        try (FileWriter fw = new FileWriter(f)) {

            sb = new StringBuilder();
            int[] arr = Arrays.stream(readText().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            fw.write(sb.toString().trim());
        }
        return sb.toString().trim();
    }
    public static String readText() throws IOException {
        File f1 = new File("part2.txt");
        try (FileWriter fw1 = new FileWriter(f1)) {
            fw1.write("13 40 24 42 12 11 5 6 2 33");
        }
        StringBuilder sb;
        try (Scanner fr = new Scanner(new File("part2.txt"), "cp1251")) {
            sb = new StringBuilder();
            while (fr.hasNextLine()) {
                sb.append(fr.nextLine());
            }
        }
        return sb.toString();
    }
}
