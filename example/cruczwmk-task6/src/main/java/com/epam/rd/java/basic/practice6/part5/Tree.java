package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>>{
    private Node<E> root;
    public boolean add(E element) {
        if(search(element)) {
            return false;
        }else {
            root = addRecursive(root, element);
            return true;
        }
    }
    Node<E> addRecursive(Node<E> root, E data)
    {
        if(root == null)
        {
            root = new Node<>(data);
            return root;
        }
        if(compare(data,root.data)<0)
        {
            root.left = addRecursive(root.left,data);
        } else if (compare(data,root.data)>0)
        {
            root.right = addRecursive(root.right, data);
        } else if(compare(data,root.data)==0) return null;
        return root;
    }
    public void add(E[] elements) {
        for (int i = 0; i <elements.length ; i++) {
                add(elements[i]);
        }
    }

    public boolean remove(E element) {
        if(!search(element)) {
            return false;
        }else {
            removeRecursive(root, element);
            return true;
        }
    }

    Node<E> removeRecursive(Node<E> root, E data)
    {
        if(root==null)
            return null;
        if(compare(data,root.data)<0)
        {
            root.left = removeRecursive(root.left,data);
        } else if(compare(data,root.data)>0)
        {
            root.right = removeRecursive(root.right,data);
        } else
        {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            root.data = minValue(root.right);
            root.right=removeRecursive(root.right,root.data);
        }
        return root;
    }
    E minValue(Node<E> root)
    {
        E minval = root.data;
        while (root.left!=null)
        {
            minval= root.left.data;
            root = root.left;
        }
        return minval;
    }

    public int compare(E o, E i)
    {
        return o.compareTo(i);
    }
    private static final class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;
        public Node(E data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
   public void print() {
        int i=0;
        inorderRec(root,i);
    }

   private void inorderRec(Node<E> root, int i) {

        if (root != null) {
            inorderRec(root.left,i+1);
            System.out.println(makeSpaces(i)+root.data);
            inorderRec(root.right,i+1);
        }
    }
    private String makeSpaces(int i)
    {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<i;j++)
        {
            sb.append("  ");
        }
        return sb.toString();
    }
    public boolean search(E value) {
        return containsNodeRecursive(root, value);
    }

    //recursive insert function
    private boolean containsNodeRecursive(Node<E> current, E value) {
        if (current == null) {
            return false;
        }
        if (compare(value, current.data)==0) {
            return true;
        }
        return compare(value, current.data)<0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

}
