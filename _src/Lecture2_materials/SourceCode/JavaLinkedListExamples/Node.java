package com.company;

/**
 * A single generic node in the linked list.
 * @param <T> The actual data in each node in the linked list.
 */
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        setNext(null);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    static void printNode(Node head)
    {
        Node curr = null;
        curr = head;
        int i = 1;
        while (curr!= null)
        {
            System.out.println("this is the Node number " + i + ", the value it stores is "+ curr.toString() );
            curr = curr.getNext();
            i++;
        }

    }
}


