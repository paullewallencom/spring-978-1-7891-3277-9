package com.loonycorn;

public class HeapsStreamingMedian {

    private static int[] randomNumberArray = new int[] {5, 6, 7, 9, 10, 2, 3, 13, 15, 17, 20, 1, 8};
    private static MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
    private static MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);

    public static void main(String[] args)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {

        for (int number : randomNumberArray) {
            double median = getStreamingMedian(number);
            System.out.println(median);
        }

        maxHeap.printHeapArray();
        minHeap.printHeapArray();
    }

    public static double getStreamingMedian(int number)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {

        if (!maxHeap.isEmpty() && number > maxHeap.getHighestPriority()) {
            minHeap.insert(number);
        } else {
            maxHeap.insert(number);
        }

        if (maxHeap.getCount() > minHeap.getCount() + 1) {
            minHeap.insert(maxHeap.removeHighestPriority());
        } else if (minHeap.getCount() > maxHeap.getCount() + 1) {
            maxHeap.insert(minHeap.removeHighestPriority());
        }

        if (maxHeap.getCount() == minHeap.getCount()) {
            return 0.5 * (maxHeap.getHighestPriority() + minHeap.getHighestPriority());
        }

        return minHeap.getCount() > maxHeap.getCount()
                ? minHeap.getHighestPriority()
                : maxHeap.getHighestPriority();
    }
}
