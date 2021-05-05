package com.epam.rd.java.basic.practice1;

public class Part6 {

    public static void main(String[] args) {
        int counter = 0;
        StringBuilder res = new StringBuilder();
        if (args==null || Integer.parseInt(args[0])==0) return;
        for (int i = 2; i <= Integer.MAX_VALUE; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++){
                if ((i % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                    res.append(i + " ");
                    counter++;
            }
            if(Integer.parseInt(args[0])==counter)
                break;
        }
        System.out.print(res.toString().trim());
    }
}