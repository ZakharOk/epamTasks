package com.epam.rd.java.basic.practice1;

public class Part4 {

    public static void main(String[] args) {
            int maxNum;
            int minNum;
            int res = 0;
            if (args == null || args.length < 1) return;
            if (Integer.parseInt(args[0]) < Integer.parseInt(args[1])) {
                maxNum = Integer.parseInt(args[1]);
                minNum = Integer.parseInt(args[0]);
            } else {
                maxNum = Integer.parseInt(args[0]);
                minNum = Integer.parseInt(args[1]);
            }
            while (minNum != 0) {
                res = maxNum % minNum;
                maxNum = minNum;
                minNum = res;
            }
            System.out.print(maxNum);
    }

}
