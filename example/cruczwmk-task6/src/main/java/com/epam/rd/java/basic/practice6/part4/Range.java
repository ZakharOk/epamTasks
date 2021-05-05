package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{
    private final int start;
    private final int end;
    private final boolean reverse;

    public Range(int n, int m) {
        start = n;
        end = m;
        reverse = true;
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        start = secBound;
        end = firstBound;
        reverse = !reversedOrder;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
    
    private final class IteratorImpl implements Iterator<Integer> {
        int pointer = start;
        @Override
        public boolean hasNext()
        {
            if(reverse) {
                return pointer <= end;
            }
            else {
                return pointer >= end;
            }
        }

        @Override
        public Integer next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            if(reverse) {
                return pointer++;
            }
            else return pointer--;
        }
        
    }

}
