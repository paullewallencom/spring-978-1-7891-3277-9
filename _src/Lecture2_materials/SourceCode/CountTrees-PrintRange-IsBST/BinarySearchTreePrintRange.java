package com.loonycorn;

/**
 * Created by jananiravi on 12/13/15.
 */
public class BinarySearchTreePrintRange {

    public static void main(String[] args) {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insert(null, five);

        insert(head, eight);
        insert(head, two);
        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        printRange(head, 2, 9);
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }

        return head;
    }

    public static void printRange(Node<Integer> root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low <= root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }

        if (low <= root.getData() && root.getData() <= high) {
            System.out.println(root.getData());
        }

        if (high > root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

}
