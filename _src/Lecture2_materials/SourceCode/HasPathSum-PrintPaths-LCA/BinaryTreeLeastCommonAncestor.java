package com.loonycorn;

/**
 * Created by jananiravi on 12/13/15.
 */
public class BinaryTreeLeastCommonAncestor {


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

        // These should all have some common ancestor.
        System.out.println("LCA of 1 and 9: " + leastCommonAncestor(three, one, nine).getData());
        System.out.println("LCA of 1 and 4: " + leastCommonAncestor(three, one, four).getData());
        System.out.println("LCA of 6 and 4: " + leastCommonAncestor(three, six, four).getData());
        System.out.println("LCA of 10 and 11: " + leastCommonAncestor(three, ten, eleven).getData());
        System.out.println("LCA of 2 and 11: " + leastCommonAncestor(three, two, eleven).getData());
        System.out.println("LCA of 5 and 8: " + leastCommonAncestor(three, five, eight).getData());
    }

    public static Node<Integer> leastCommonAncestor(
            Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        Node<Integer> leftLCA = leastCommonAncestor(root.getLeftChild(), a, b);
        Node<Integer> rightLCA = leastCommonAncestor(root.getRightChild(), a, b);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        return rightLCA;
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
