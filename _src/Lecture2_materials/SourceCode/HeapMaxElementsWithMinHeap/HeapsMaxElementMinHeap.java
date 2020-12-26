package com.loonycorn;

/**
 * Created by jananiravi on 12/22/15.
 */
public class HeapsMaxElementMinHeap {

    public static void main(String[] args)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException{
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.printHeapArray();
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(3);
        System.out.println("Maximum element: " + getMaximum(minHeap));
        minHeap.printHeapArray();
        minHeap.insert(11);
        minHeap.insert(15);
        minHeap.printHeapArray();
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.printHeapArray();

        System.out.println("Maximum element: " + getMaximum(minHeap));
    }


    public static int getMaximum(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = lastParentIndex + 1;

        int maxElement = minHeap.getElementAtIndex(firstChildIndex);
        for (int i = firstChildIndex; i <= lastIndex; i++) {
            if (maxElement < minHeap.getElementAtIndex(i)) {
                maxElement = minHeap.getElementAtIndex(i);
            }
        }

        return maxElement;
    }
}
