package com.loonycorn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jananiravi on 12/22/15.
 */
public class HeapsMergeKSortedLists {

    public static void main(String[] args)
            throws MinHeap.HeapFullException, MinHeap.HeapEmptyException{

        int[] array1 = new int[] {4, 6, 9, 11, 19, 21, 23};
        int[] array2 = new int[] {2, 5, 12, 18, 19, 31, 33};
        int[] array3 = new int[] {5, 15, 25, 35, 45, 55, 65, 75};
        int[] array4 = new int[] {10, 20, 30, 40, 50, 60, 70};

        mergeKSortedLists(29,
                new ArrayList<>(Arrays.asList(4, 6, 9, 11, 19, 21, 23)),
                new ArrayList<>(Arrays.asList(2, 5, 12, 18, 19, 31, 33)),
                new ArrayList<>(Arrays.asList(5, 15, 25, 35, 45, 55, 65, 75)),
                new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70)));
    }

    public static void mergeKSortedLists(int totalElements, List<Integer>... lists)
            throws MinHeap.HeapFullException, MinHeap.HeapEmptyException {
        MinHeap<Element> minHeap = new MinHeap<>(Element.class, lists.length);

        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list = lists[i];
            if (!list.isEmpty()) {
                minHeap.insert(new Element(i, list.remove(0)));
            }
        }

        while (sortedList.size() < totalElements) {
            Element element = minHeap.removeHighestPriority();
            sortedList.add(element.getValue());

            List<Integer> list = lists[element.getListIndex()];
            if (!list.isEmpty()) {
                minHeap.insert(new Element(element.getListIndex(), list.remove(0)));
            }
        }

        printList(sortedList);
    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static class Element implements Comparable<Element> {

        private Integer listIndex;
        private Integer value;

        public Element(Integer listIndex, Integer value) {
            this.listIndex = listIndex;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public Integer getListIndex() {
            return listIndex;
        }

        @Override
        public int compareTo(Element element) {
            return value - element.value;
        }
    }
}
