package com.epam.rd.java.basic.practice5;

import java.util.Scanner;

public class Part2 {

    public static void main(final String[] args) {
        Spam.main(args);
        Spam s = new Spam(new String[] { "@@@", "bbbbbbb" },new int[] { 222, 333 });
        s.start();
        Scanner sc =new Scanner(System.in);
        while (true) {
            if ("".equals(sc.nextLine())) {
                s.stop();
                return;
            }
        }
    }

}
