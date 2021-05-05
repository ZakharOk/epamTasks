package com.epam.rd.java.basic.practice6.part4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RangeTest {
    @Test
    public void printRegular()
    {
        Range r = new Range(3,5);
        StringBuilder s = new StringBuilder();
        for (Integer i :r) {
            s.append(i).append(' ');
        }
        assertEquals("3 4 5",s.toString().trim());
    }
    @Test
    public void printReverse()
    {
        Range r = new Range(3,5,true);
        StringBuilder s = new StringBuilder();
        for (Integer i :r) {
            s.append(i).append(' ');
        }
        assertEquals("5 4 3",s.toString().trim());
    }
}
