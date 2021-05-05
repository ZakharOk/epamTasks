package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    Node head;
    private int size = 0;
    @Override
    public void clear() {
       head = new Node();
        size=0;
    }

    @Override
    public int size() {
        if(size<0) {
            size=0;
            return size;
        }
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        Node n = head;
        boolean isHeadPrint = false;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            if(!hasNext())
                throw new NoSuchElementException();
            if(!isHeadPrint) {
                isHeadPrint = true;
                return n.data;
            }
            n = n.next;
            return n.data;
        }

    }
    @Override
    public void push(Object element) {
        Node addingNode;
        addingNode = new Node();
        if(head==null) {
            addingNode.data = element;
            head = addingNode;
        }
        else {
            addingNode.data = element;
            addingNode.next = head;
            head = addingNode;
        }
        size++;
    }

    @Override
    public Object pop() {
        if(head==null) {
            return null;
        }
        Node headTmp = head;
        if(head.next!=null)
            head = head.next;
        size--;
        return headTmp.data;
    }

    @Override
    public Object top() {
        return head.data;
    }

    @Override
    public String toString() {
        IteratorImpl iterator = new IteratorImpl();
        StringBuilder sb = new StringBuilder();
        if(head==null)
            return "[]";
        sb.append(']');
        for (;;)
        {
            sb.append(iterator.next());
            if(!iterator.hasNext()) {
                return sb.append('[').reverse().toString().replace("llun","null");
            }
            sb.append(" ,");
        }
    }

    private static class Node
    {
        private Object data;
        private Node next;
    }

    public static void main(String[] args) {
        StackImpl s = new StackImpl();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push(null);
        s.push("C");
        for (Object o:s) {
            System.out.println(o);
        }
        System.out.println(s.toString());
        s.size();
        s.top();
        s.pop();
        s.clear();
        s.size();

    }

}
