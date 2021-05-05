package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    NodeQueue headQueue;
    int sizeQueue = 0;

    @Override
    public void clear() {
        headQueue = new NodeQueue();
        sizeQueue = 0;
    }

    @Override
    public int size() {
        return sizeQueue;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        NodeQueue n = headQueue;
        boolean isheadQueuePrint = false;

        @Override
        public boolean hasNext() {
            return n.nextQueue != null;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            if (!isheadQueuePrint) {
                isheadQueuePrint = true;
                return n.dataQueue;
            }
            n = n.nextQueue;
            return n.dataQueue;
        }
    }

    @Override
    public void enqueue(Object element) {
        NodeQueue nodeQueue = new NodeQueue();
        nodeQueue.dataQueue = element;
        if (headQueue == null) {
            headQueue = nodeQueue;
        } else {
            NodeQueue n = headQueue;
            while (n.nextQueue != null) {
                n = n.nextQueue;
            }
            n.nextQueue = nodeQueue;
        }
        sizeQueue++;
    }

    @Override
    public Object dequeue() {
        if (headQueue == null) {
            return null;
        }
        NodeQueue headQueueTmp = headQueue;
        if (headQueue.nextQueue != null)
            headQueue = headQueue.nextQueue;
        sizeQueue--;
        return headQueueTmp.dataQueue;
    }

    @Override
    public Object top() {
        return headQueue.dataQueue;
    }

    @Override
    public String toString() {
        IteratorImpl iterator = new IteratorImpl();
        StringBuilder sb = new StringBuilder();
        if (headQueue == null)
            return "[]";
        sb.append('[');
        for (; ; ) {
            sb.append(iterator.next());
            if (!iterator.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }

    private static class NodeQueue {
        private Object dataQueue;
        private NodeQueue nextQueue;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.top();
        queue.dequeue();
        queue.size();
        System.out.println(queue.toString());
        queue.clear();
    }
}
