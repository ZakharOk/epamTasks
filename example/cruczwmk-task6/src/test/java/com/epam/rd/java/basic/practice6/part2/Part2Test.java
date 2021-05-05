package com.epam.rd.java.basic.practice6.part2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Part2Test {
    @Test
    public void timeTestIndex()
    {
        long al = Part2.removeByIndex(Part2.arrayListFill(10000),4);
        long ll = Part2.removeByIndex(Part2.linkedListFill(10000),4);
        assertTrue(ll / al > 3);
    }
    @Test
    public void timeTestIterator()
    {
        long al = Part2.removeByIterator(Part2.arrayListFill(10000),4);
        long ll = Part2.removeByIterator(Part2.linkedListFill(10000),4);
        assertTrue(ll / al < 2);
    }
}