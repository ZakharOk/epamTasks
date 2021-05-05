package com.epam.rd.java.basic.practice6.part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void arrive()
    {
        Parking p = new Parking(4);
        boolean arr = p.arrive(3);
        assertTrue(arr);
        boolean dep = p.depart(3);
        assertTrue(dep);
    }
    @Test
    public void depart()
    {
        Parking p = new Parking(4);
        p.arrive(3);
        boolean dep = p.depart(3);
        assertTrue(dep);
    }
    @Test
    public void departIfAbsent()
    {
        Parking p = new Parking(4);
        boolean dep = p.depart(3);
        assertFalse(dep);
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    public void print()
    {
        Parking p = new Parking(4);
        p.arrive(1);
        p.arrive(2);
        p.print();
        assertEquals("0110", output.toString());
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}