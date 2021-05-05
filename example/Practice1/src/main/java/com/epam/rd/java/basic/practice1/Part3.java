package com.epam.rd.java.basic.practice1;

public class Part3 {

    public static void main(String[] args) {
        StringBuilder words = new StringBuilder();
        for (String str:args) {
            words.append(" "+str);
        }
        System.out.print(words.toString().trim());
    }
	
}
