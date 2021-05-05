package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    
    public static void main(String[] args) {
        Parking p = new Parking(4);
        System.out.println(p.arrive(2));
        p.print();
        System.out.println(p.arrive(3));
        System.out.println(p.depart(3));
        p.print();
    }

}
