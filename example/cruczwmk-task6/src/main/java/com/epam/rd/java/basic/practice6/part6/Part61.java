package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part61 {

    private static Word[] arr = new Word[0];
    private static SortedWords[] sortedWords = new SortedWords[]{new SortedWords(),new SortedWords(),new SortedWords()};

    public static void main(String[] args) {
        String input = getInput(args[0]);
        findFreq(input);
        print();
        arr=new Word[0];
        sortedWords = new SortedWords[]{new SortedWords(),new SortedWords(),new SortedWords()};
    }

    private static void findFreq(String input) {
        Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher m = p.matcher(input);
        String word;
        while (m.find()) {
            word = m.group();
            if (!isIn(word)) {
                add(word);
            }
        }
    }

    static boolean isIn(String word){
        for(Word str : arr){
            if(str.isIt(word)) return true;
        }
        return false;
    }

    private static void add(String word) {
        Word[] tmp = Arrays.copyOf(arr, arr.length + 1);
        tmp[arr.length] = new Word(word);
        arr = tmp;
    }

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "utf-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

    private static void print() {
        Arrays.sort(arr);
        if (arr.length >= 3) {
            for (int i = 0; i < 3; i++) {
                sortedWords[i].content=arr[i].content;
                sortedWords[i].frequency=arr[i].frequency;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                sortedWords[i].content=arr[i].content;
                sortedWords[i].frequency=arr[i].frequency;
            }
        }
        Arrays.sort(sortedWords);
        for(int i=2; i>=0; i--){
            if (sortedWords[i]!=null) System.out.println(sortedWords[i]);
        }
    }

    private static class Word implements Comparable<Word> {

        private final String content;
        private int frequency = 1;

        public Word(String word) {
            content = word;
        }

        boolean isIt(String word) {
            if (content.equals(word)) {
                frequency++;
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Word o) {
            return o.frequency - frequency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return frequency == word.frequency &&
                    Objects.equals(content, word.content);
        }

        @Override
        public int hashCode() {
            return Objects.hash(content, frequency);
        }
    }

    private static class SortedWords implements Comparable<SortedWords> {

        private String content;
        private int frequency = 1;

        @Override
        public int compareTo(SortedWords o) {
            return content.compareTo(o.content);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SortedWords word = (SortedWords) o;
            return frequency == word.frequency &&
                    Objects.equals(content, word.content);
        }

        @Override
        public int hashCode() {
            return Objects.hash(content, frequency);
        }

        @Override
        public String toString() {
            return content + " ==> " + frequency;
        }
    }
}
