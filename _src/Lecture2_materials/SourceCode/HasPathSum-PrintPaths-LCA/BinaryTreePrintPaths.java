package com.loonycorn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananiravi on 12/13/15.
 */
public class BinaryTreePrintPaths {

    public static void main(String[] args) throws
            Queue.QueueUnderflowException, Queue.QueueOverflowException {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);
        Node<Integer> eleven = new Node<>(11);

        three.setLeftChild(one);
        three.setRightChild(nine);
        nine.setLeftChild(two);
        nine.setRightChild(four);
        one.setLeftChild(six);
        six.setRightChild(seven);
        six.setLeftChild(ten);
        two.setRightChild(five);
        four.setLeftChild(eight);
        four.setRightChild(eleven);

        printPaths(three, new ArrayList<>());
    }

    public static void print(List<Node<Integer>> pathList) {
        for (Node<Integer> node : pathList) {
            System.out.print(node.getData() + "->");
        }
        System.out.println();
    }

    public static void printPaths(
            Node<Integer> root, List<Node<Integer>> pathList) {
        if (root == null) {
            return;
        }

        pathList.add(root);
        printPaths(root.getLeftChild(), pathList);
        printPaths(root.getRightChild(), pathList);

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            print(pathList);
        }

        pathList.remove(root);
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
