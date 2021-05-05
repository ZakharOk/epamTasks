package com.epam.rd.java.basic.practice1;


public class Part2 {
    public static void main(String[] args) {
        int sum = 0;
        for (String s: args) {
            if(args.length<2)
                break;
            sum+=Integer.parseInt(s);
        }
        System.out.print(sum);
    }

}
