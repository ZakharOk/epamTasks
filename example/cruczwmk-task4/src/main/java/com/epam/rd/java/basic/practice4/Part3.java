package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    static Logger log = Logger.getLogger(Part3.class.getName());
    public static void main(String[] args) {
        try {
            search();
        } catch (IOException e) {
            Part3.log.severe(e.getMessage());
        }
    }
    public static void search() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String request = sc.next();
            switch (request) {
                case "double":
                    findDouble();
                    System.out.println();
                    search();
                    break;
                case "int":
                    findInt();
                    System.out.println();
                    search();
                    break;
                case "char":
                    findChar();
                    System.out.println();
                    search();
                    break;
                case "String":
                    findString();
                    System.out.println();
                    search();
                    break;
                case "stop":
                    break;
                default:
                    System.out.println("Incorrect input");
                    search();
                    break;
            }
        }
    }
    private static void findString() throws IOException {
        Pattern p = Pattern.compile("\\b[A-z\\p{InCYRILLIC}]{2,}\\b");
        Matcher m = p.matcher(readText());
        while (m.find())
        {
            System.out.print(m.group()+" ");
        }
    }
    private static void findChar() throws IOException {
        Pattern p = Pattern.compile("(?<=\\s|^)([A-z\\p{InCYRILLIC}]{1})(?=\\s|$)");
        Matcher m = p.matcher(readText());
        while (m.find())
        {
            System.out.print(m.group()+" ");
        }
    }

    private static void findInt() throws IOException {
        Pattern p = Pattern.compile("(?<=\\s|^)\\d+(?=\\s|$)");
        Matcher m = p.matcher(readText());
        while (m.find())
        {
            System.out.print(m.group()+" ");
        }
    }
    private static void findDouble() throws IOException {
        Pattern p = Pattern.compile("\\d*\\.\\d+");
        Matcher m = p.matcher(readText());
        while (m.find())
        {
            System.out.print(m.group()+" ");
        }
    }

    public static String readText() throws IOException {
        StringBuilder sb;
        try (Scanner fr = new Scanner(new File("part3.txt"), "cp1251")) {
            sb = new StringBuilder();
            while (fr.hasNextLine()) {
                sb.append(fr.nextLine()).append("\n");
            }
        }
        return sb.toString();
    }
}
