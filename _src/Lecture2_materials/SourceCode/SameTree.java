package com.loonycorn;

/**
 * Created by jananiravi on 11/19/15.
 */
public class SameTree {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        one.addChildren(two, three);
        two.addChildren(six, null);
        three.addChildren(four, five);
        four.addChildren(seven, null);
        five.addChildren(null, eight);

        Node head1 = one;

        one = new Node(1);
        two = new Node(2);
        three = new Node(3);
        four = new Node(4);
        five = new Node(5);
        six = new Node(6);
        seven = new Node(7);
        eight = new Node(8);

        one.addChildren(two, three);
        two.addChildren(six, null);
        three.addChildren(four, five);
        four.addChildren(seven, null);
        five.addChildren(null, eight);

        System.out.println("Same tree?: " + sameTree(head1, one));
    }

    public static boolean sameTree(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null) {
            return false;
        } else if (head2 == null) {
            return false;
        }


        if (sameTree(head1.getLeft(), head2.getLeft())
                && sameTree(head1.getRight(), head2.getRight())) {
            return head1.getId() == head2.getId();
        }

        return false;
    }

    public static class Node {
        private int id;
        private Node left;
        private Node right;

        public Node(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public Node getLeft() {
            return left;
        }

        public void addChildren(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        public Node getRight() {
            return right;
        }

    }
}
