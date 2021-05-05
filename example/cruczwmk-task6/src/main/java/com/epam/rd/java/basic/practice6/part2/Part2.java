package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        System.out.println("ArrayList#Index: "+removeByIndex(arrayListFill(10000),4)+" ms");
        System.out.println("LinkedList#Index: "+removeByIndex(linkedListFill(10000),4)+" ms");
        System.out.println("ArrayList#Iterator: "+removeByIterator(arrayListFill(10000),4)+" ms");
        System.out.println("LinkedList#Iterator: "+removeByIterator(linkedListFill(10000),4)+" ms");
    }
    public static List<Integer> arrayListFill(int k)
    {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            list.add(i);
        }
        return list;
    }
    public static List<Integer> linkedListFill(int k)
    {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<k;i++)
        {
            list.add(i);
        }
        return list;
    }
    public static long removeByIndex(final List<Integer> list, final int k) {
        int operationIterator = 1;
        int index = 0;
        long start = System.currentTimeMillis();
        while (list.size()!=1)
        {
            while (index<=list.size())
            {
                if(list.size()==1)
                    break;
                if(index==list.size())
                {
                    index = 0;
                }
                if(operationIterator%k==0)
                {
                    list.remove(index);
                    index--;
                }
                index++;
                operationIterator++;
            }
            operationIterator--;
            index=0;
        }
        return System.currentTimeMillis() - start;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        Iterator iterator = list.iterator();
        long start = System.currentTimeMillis();
        int iteration = 0;
            while(iterator.hasNext())
            {
                iterator.next();
                iteration++;
                if(iteration%k == 0) {
                    iterator.remove();
                }
                if(!iterator.hasNext())
                    iterator = list.iterator();
            }
        return System.currentTimeMillis() - start;
    }
}
