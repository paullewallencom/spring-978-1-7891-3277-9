package com.loonycorn;

/**
 * Created by jananiravi on 12/13/15.
 */
public class BinaryTreeHasPathSum {

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

        // These should all be true.
        System.out.println("Has path sum 20: " + hasPathSum(three, 20));
        System.out.println("Has path sum 17: " + hasPathSum(three, 17));
        System.out.println("Has path sum 19: " + hasPathSum(three, 19));
        System.out.println("Has path sum 24: " + hasPathSum(three, 24));
        System.out.println("Has path sum 27: " + hasPathSum(three, 27));

        // These should all be false.
        System.out.println("Has path sum 30: " + hasPathSum(three, 30));
        System.out.println("Has path sum 4: " + hasPathSum(three, 4));
    }

    public static boolean hasPathSum(Node<Integer> root, int sum) {
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return sum == root.getData();
        }

        int subSum = sum - root.getData();
        if (root.getLeftChild() != null) {
            boolean hasPathSum = hasPathSum(root.getLeftChild(), subSum);
            if (hasPathSum) {
                return true;
            }
        }
        if (root.getRightChild() != null) {
            boolean hasPathSum = hasPathSum(root.getRightChild(), subSum);
            if (hasPathSum) {
                return true;
            }
        }

        return false;
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
