package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private final int initSize;
    private final int cutRate;
    private Object[] array;
    private int currentPointer = 0;
    private int pointer = 0;

    public ArrayImpl() {
        this.initSize = 2;
        this.array = new Object[initSize];
        this.cutRate = 4;
    }

    public ArrayImpl(int initSize) {
        this.initSize = initSize;
        this.array = new Object[initSize];
        this.cutRate = 4;
    }

    @Override
    public void clear() {
        for (int i = pointer; i > 0; i--) {
            remove(pointer);
        }
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return currentPointer < pointer;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentPointer++];
        }

    }

    @Override
    public void add(Object element) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = element;
    }

    @Override
    public void set(int index, Object element) {
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int itr = 0; itr < pointer; itr++) {
            if (array[itr] == null && itr < pointer - 1) {
                continue;
            } else if (array[itr] == null)
                return -1;
            if (array[itr].equals(element)) {
                return itr;
            } else if (itr + 1 == pointer)
                return -1;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (pointer - index >= 0) System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        if (array.length > initSize && pointer < array.length / cutRate)
            resize(array.length / 2);
    }

    @Override
    public String toString() {
        currentPointer = 0;
        StringBuilder b = new StringBuilder();
        Iterator<Object> i = iterator();
        if (!i.hasNext())
            return "[]";
        b.append('[');
        for (; ; ) {
            b.append(i.next());
            if (!i.hasNext())
                return b.append(']').toString();
            b.append(", ");
        }
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public static void main(String[] args) {
        ArrayImpl ai = new ArrayImpl();
        ArrayImpl al = new ArrayImpl(4);
        al.add("AA");
        al.add("AB");
        al.add(null);
        al.add("AC");
        al.indexOf(null);
        ai.add("A");
        ai.add("B");
        ai.add("C");
        for (Object s : ai) {
            System.out.println(s);
        }
        ai.clear();
        ai.size();
        ai.add("A");
        ai.add("B");
        ai.add("C");
        ai.remove(2);
        ai.set(1, "K");
        ai.get(1);
        ai.indexOf("K");
        ai.clear();
    }

}
