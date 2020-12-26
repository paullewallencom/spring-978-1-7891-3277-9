package com.loonycorn;

import java.util.*;

/**
 * Created by jananiravi on 11/18/15.
 */
public class Subsets {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);

        List<List<Integer>> subsetList = new ArrayList<>();
        populateSubsets(subsetList, numberList);

        print(subsetList);
    }

    public static void print(List<List<Integer>> subsetList) {
        for (List<Integer> subset : subsetList) {
            Collections.sort(subset);

            System.out.print("{");
            for (Integer i : subset) {
                System.out.print(i + ",");
            }
            System.out.println("}");
        }
    }

    public static void populateSubsets(List<List<Integer>> subsetList, List<Integer> numberList) {
        if (numberList.isEmpty()) {
            subsetList.add(new ArrayList<>());
            return;
        }

        int currentNum  = numberList.get(0);
        numberList.remove(0);

        populateSubsets(subsetList, numberList);

        List<List<Integer>> iteratingList = new ArrayList<>();
        iteratingList.addAll(subsetList);
        for (List<Integer> subset : iteratingList) {
            List<Integer> newSubset = new ArrayList<>();

            newSubset.addAll(subset);
            newSubset.add(currentNum);

            subsetList.add(newSubset);
        }
    }
}
