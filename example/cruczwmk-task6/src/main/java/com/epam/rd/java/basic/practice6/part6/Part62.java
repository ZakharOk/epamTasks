package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part62 {

    private static Word[] arr = new Word[0];

    public static void main(String[] args) {
        String input = Part61.getInput(args[0]);
        findLong(input);
        print();
        arr = new Word[0];
    }

    private static void findLong(String input) {
        Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher m = p.matcher(input);
        StringBuilder duplicates = new StringBuilder(" ");
        StringBuilder word;
        while (m.find()) {
            word = new StringBuilder(m.group());
            if (!duplicates.toString().contains(" " + word + " ")) {
                duplicates.append(word).append(" ");
                add(word.toString());
            }
        }
    }

    private static void add(String word) {
        Word[] tmp = Arrays.copyOf(arr, arr.length + 1);
        tmp[arr.length] = new Word(word);
        arr = tmp;
    }

    private static void print() {
        Arrays.sort(arr);
        if (arr.length >= 3) {
            for (int i = 0; i < 3; i++) {
                System.out.println(arr[i].content + " ==> " + arr[i].content.length());
            }
        } else {
            for (Word s : arr) {
                System.out.println(s.content + " ==> " + s.content.length());
            }
        }
    }

    private static class Word implements Comparable<Word> {

        final String content;

        private Word(String word) {
            content = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(content, word.content);
        }

        @Override
        public int hashCode() {
            return Objects.hash(content);
        }

        @Override
        public int compareTo(Word o) {
            return o.content.length() - content.length();
        }
    }
}
