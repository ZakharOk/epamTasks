package com.epam.rd.java.basic.practice6.part5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void addDuplicate()
    {
        Tree<Integer> t = new Tree<>();
        t.add(3);
        boolean duplicate = t.add(3);
        assertFalse(duplicate);
    }
}
