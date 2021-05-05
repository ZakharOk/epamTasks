package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterator<Object> {
    static Logger log = Logger.getLogger(Part4.class.getName());
    static int localIter = -1;
    static int initIter = 0;
    String[] res = new String[5];
    public static void main(String[] args) {
        Part4 p = new Part4();
        try {
            p.arrString();
        } catch (IOException e) {
            Part4.log.severe(e.getMessage());
        }
        while (p.hasNext())
        {
            System.out.println(p.next());
        }
    }

    @Override
    public boolean hasNext() {
            incrementLocal();
            return res[localIter]!=null;
    }

    @Override
    public Object next() {
        if(res==null) {
            throw new NoSuchElementException();
        }
            return res[localIter];
    }
    public static String readText() throws IOException {
        StringBuilder sb;
        try (Scanner fr = new Scanner(new File("part4.txt"), "cp1251")) {
            sb = new StringBuilder();
            while (fr.hasNextLine()) {
                sb.append(fr.nextLine()).append(" ");
            }
        }
        return sb.toString();
    }
    static void increment()
    {
        initIter++;
    }
    static void incrementLocal()
    {
        localIter++;
    }
    private void arrString() throws IOException {
        Pattern p = Pattern.compile("[A-Z\\u0400-\\u04FF][^.]+[.]");
        Matcher m = p.matcher(readText());

        while (m.find())
        {
            res[initIter] = m.group();
            increment();
        }
    }
}
