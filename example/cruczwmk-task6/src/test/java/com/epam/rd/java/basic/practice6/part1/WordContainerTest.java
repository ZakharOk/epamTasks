package com.epam.rd.java.basic.practice6.part1;

import com.epam.rd.java.basic.practice6.Demo;
import org.junit.Test;


import static org.junit.Assert.*;

public class WordContainerTest {
    @Test
    public void demoMain() {
        Demo.main(new String[0]);
        assertTrue(true);
    }

    @Test
    public void part1Main() {

        new Part1();
        Part1.main(new String[0]);
        assertTrue(true);
    }
}
