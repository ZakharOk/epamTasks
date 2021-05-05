package com.epam.rd.java.basic.practice6.part4;


public class Part4 {

    public static void main(String[] args) {
       Range r = new Range(3,10);
       Range r1 = new Range(3,10,true);
        for (Integer integer:r) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer integer:r1) {
            System.out.print(integer+" ");
        }
    }

}
