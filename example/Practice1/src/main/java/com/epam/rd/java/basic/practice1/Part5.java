package com.epam.rd.java.basic.practice1;


public class Part5 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0;i<args[0].length();i++)
        {
            sum += Integer.parseInt(String.valueOf(args[0].charAt(i)));
        }
        System.out.print(sum);
    }
	
}
