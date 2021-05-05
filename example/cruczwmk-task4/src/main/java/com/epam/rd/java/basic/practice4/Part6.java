package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    static Logger log = Logger.getLogger(Part6.class.getName());
    public static void main(String[] args)  {
        try {
            request();
        } catch (IOException e) {
            Part6.log.severe(e.getMessage());
        }
    }
    private static void request() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String req = sc.nextLine();
            switch (req) {
                case "Latn":
                    System.out.println(req + ": " + latnInput());
                    request();
                    break;
                case "Cyrl":
                    System.out.println(req + ": " + cyrlInput());
                    request();
                    break;
                case "stop":
                    break;
                default:
                    System.out.println(req + ": " + "Incorrect input");
                    request();
                    break;
            }
        }
    }
    private static String cyrlInput() throws IOException {
        Pattern p = Pattern.compile("\\b[\\p{InCYRILLIC}^.]{1,}\\b");
        Matcher m = p.matcher(readText());
        StringBuilder sb = new StringBuilder();
        while (m.find())
        {
            sb.append(m.group().trim()).append(" ");
        }
        return sb.toString().trim()+" ";
    }
    private static String latnInput() throws IOException {
        Pattern p = Pattern.compile("\\b[\\w]{1,}\\b");
        Matcher m = p.matcher(readText());
        StringBuilder sb = new StringBuilder();
        while (m.find())
        {
            sb.append(m.group()).append(" ");
        }
        return sb.toString().trim()+" ";
    }
    public static String readText() throws IOException {
        StringBuilder sb;
        try (Scanner fr = new Scanner(new File("part6.txt"), "cp1251")) {
            sb = new StringBuilder();
            while (fr.hasNextLine()) {
                sb.append(fr.nextLine()).append("\n");
            }
        }
        return sb.toString();
    }

}
