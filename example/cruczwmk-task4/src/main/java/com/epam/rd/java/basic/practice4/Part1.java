package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    static Logger log = Logger.getLogger(Part1.class.getName());
    public static void main(String[] args)  {
        Pattern p = Pattern.compile("(\\b([\\w\\u0400-\\u04FF]){4,}\\b)");
        Matcher m;

        try {
            m = p.matcher(readText());
            String s = readText();
            while (m.find())
            {
                s = s.replace(m.group(),m.group().substring(2));
            }
            System.out.println(s);
        } catch (IOException e) {
            Part1.log.severe(e.getMessage());
        }
    }

    public static String readText() throws IOException {
        StringBuilder sb;
        try (Scanner fr = new Scanner(new File("part1.txt"), "cp1251")) {
            sb = new StringBuilder();
            while (fr.hasNextLine()) {
                sb.append(fr.nextLine()).append("\n");
            }
        }
        return sb.toString().trim();
    }
}
