package com.epam.rd.java.basic.practice6.part5;

public class Part5 {
    
    public static void main(String[] args) {
        Tree<Integer> t = new Tree<>();
        t.add(3);
        t.add(3);
        t.add(4);
        t.add(new Integer[]{1,2,4});
        t.print();
    }
    
}
