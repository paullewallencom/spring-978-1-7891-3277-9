package com.loonycorn;

/**
 * Created by jananiravi on 12/13/15.
 */
public class BinaryTreesCountTrees {

    public static void main(String[] args) {

        System.out.println("Tree count for 1 node: " + countTrees(1));
        System.out.println("Tree count for 2 nodes: " + countTrees(2));
        System.out.println("Tree count for 3 nodes: " + countTrees(3));
        System.out.println("Tree count for 6 nodes: " + countTrees(6));
    }

    public static int countTrees(int numNodes) {
        if (numNodes <= 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= numNodes; i++) {
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - i);

            sum = sum + (countLeftTrees * countRightTrees);
        }

        return sum;
    }
}
