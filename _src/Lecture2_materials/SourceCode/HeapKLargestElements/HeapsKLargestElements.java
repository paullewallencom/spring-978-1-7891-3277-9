package com.loonycorn;

import java.io.IOException;

/**
 * Created by jananiravi on 12/22/15.
 */
public class HeapsKLargestElements {

    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
        printMaximumKElements(3);
        printMaximumKElements(5);
        printMaximumKElements(6);
    }

    public static void printMaximumKElements(int k)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);

        for (int number : randomNumberArray) {
            if (minHeap.isEmpty()) {
                minHeap.insert(number);
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number) {
                if (minHeap.isFull()) {
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(number);
            }
        }

        minHeap.printHeapArray();
    }
}
