package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    NodeList headList;
    int sizeList = 0;
    @Override
    public void clear() {
        headList.nextList =null;
        headList = null;
        sizeList=0;
    }

    @Override
    public int size() {
        return sizeList;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        NodeList n = headList;
        boolean isheadListPrint = false;
        @Override
        public boolean hasNext() {
            return n.nextList!=null;
        }

        @Override
        public Object next() {
            if(!hasNext())
                throw new NoSuchElementException();
            if(!isheadListPrint) {
                isheadListPrint = true;
                return n.dataList;
            }
            n = n.nextList;
            return n.dataList;
        }

    }

    @Override
    public void addFirst(Object element) {
        NodeList nodeList = new NodeList();
        if(headList==null) {
            nodeList.dataList = element;
            headList = nodeList;
        }
        else {
            nodeList.dataList = element;
            nodeList.nextList = headList;
            headList = nodeList;
        }
        sizeList++;
    }

    @Override
    public void addLast(Object element) {
        NodeList nodeList = new NodeList();
        nodeList.dataList = element;
        nodeList.nextList = null;
        if(headList==null)
        {
            headList = nodeList;
        } else {
            NodeList n = headList;
            while (n.nextList!=null)
            {
                n = n.nextList;
            }
            n.nextList = nodeList;
        }
        sizeList++;
    }

    @Override
    public void removeFirst() {
        if (headList==null)
            return;
        headList = headList.nextList;
        sizeList--;
    }

    @Override
    public void removeLast() {
        NodeList nodeList = new NodeList();
        nodeList.nextList = null;
        int curPt =0;
        if(headList == null)
        {
            return;
        }
        else
        {
            NodeList n = headList;
            while (curPt<sizeList-2)
            {
                curPt++;
                n = n.nextList;
            }
            n.nextList = null;
        }
        sizeList--;
    }

    @Override
    public Object getFirst() {
        if (headList==null)
            return null;
        return headList.dataList;
    }

    @Override
    public Object getLast() {
        if (headList==null)
            return null;
        NodeList nodeList = headList;
        while(nodeList.nextList!=null)
        {
            nodeList = nodeList.nextList;
        }
        return nodeList.dataList;
    }

    @Override
    public Object search(Object element) {
        if(headList==null)
            return null;
        if(headList.dataList.equals(element)) {
            return headList.dataList;
        }
        NodeList nodeList = headList;

        while (nodeList.nextList!=null)
        {
            nodeList = nodeList.nextList;
            if(nodeList.dataList != null&& nodeList.dataList.equals(element)) {
                    return nodeList.dataList;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        NodeList nodeList = headList;
        if(headList.dataList.equals(element)) {
            headList = headList.nextList;
            sizeList--;
            return true;
        }
        if(element==null) {
            while (nodeList.nextList != null) {
                if(nodeList.nextList.dataList==null) {
                    nodeList.nextList = nodeList.nextList.nextList;
                    sizeList--;
                    return true;
                }
                nodeList=nodeList.nextList;
            }
            return false;
        }
        while (nodeList.nextList!=null)
        {
            if(nodeList.nextList.dataList==null)
            {
               nodeList = nodeList.nextList;
               continue;
            } else
            if(nodeList.nextList.dataList.equals(element)) {
                nodeList.nextList.dataList = null;
                nodeList.nextList = nodeList.nextList.nextList;
                sizeList--;
                return true;
            }
            nodeList = nodeList.nextList;
        }
        return false;
    }

    @Override
    public String toString() {
        IteratorImpl iterator = (IteratorImpl) iterator();
        StringBuilder sb = new StringBuilder();
        if (headList==null)
            return "[]";
        sb.append("[");
        for(;;)
        {
                sb.append(iterator.next());
                if (!iterator.hasNext()) {
                    return sb.append(']').toString();
                }
            sb.append(", ");
        }
    }
    private static class NodeList {

        private Object dataList;
        private NodeList nextList;

    }

    public static void main(String[] args) {
        ListImpl l = new ListImpl();
        l.addLast("H");
        l.addLast(null);
        l.addLast("A");
        l.addLast("B");
        l.addLast("L");
        l.addFirst("F");
        for (Object s: l) {
            System.out.println(s);
        }
        l.remove("A");
        System.out.println(l.toString());
        System.out.println(l.size());
        System.out.println(l.getFirst());
        System.out.println(l.getLast());
        System.out.println(l.search("C"));
        l.removeFirst();
        l.removeLast();
        l.remove("L");
        System.out.println(l.toString());
    }
}
