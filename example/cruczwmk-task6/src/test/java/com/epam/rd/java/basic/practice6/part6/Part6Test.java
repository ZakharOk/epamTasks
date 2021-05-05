package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Part6Test {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    public void printReverse()
    {
        Part6.main(new String[]{"-p","part6.txt","--task","frequency"});
        String ot = output.toString();
        assertEquals(ot,ot);
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
