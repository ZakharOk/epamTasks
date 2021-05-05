package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part63 {

    private static String[] arr = new String[0];

    public static void main(String[] args) {
        String input = Part61.getInput(args[0]);
        findDuplicate(input);
        print(arr);
        arr= new String[0];
    }

    private static void findDuplicate(String input) {
        Pattern p = Pattern.compile("(?s)\\b([a-zA-Z]+?)\\b(?=.*\\b\\1\\b)");
        Matcher m = p.matcher(input);
        StringBuilder word;
        StringBuilder duplicates = new StringBuilder(" ");
        while (m.find()) {
            word = new StringBuilder(m.group());
            if (!duplicates.toString().contains(" " + word + " ")) {
                duplicates.append(word + " ");
                add(word.reverse().toString());
            }
        }
    }

    private static void add(String word) {
        String[] tmp = Arrays.copyOf(arr, arr.length + 1);
        tmp[arr.length] = word;
        arr = tmp;
    }

    public static void print(String[] arr) {
        if (arr.length >= 3) {
            for (int i = 0; i < 3; i++) {
                System.out.println(arr[i].toUpperCase(Locale.ROOT));
            }
        } else {
            for (String s : arr) {
                System.out.println(s.toUpperCase(Locale.ROOT));
            }
        }
    }
}
