package com.company;

import java.util.Arrays;

public class HeapSort {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("execution time: " + elapsed + " ms");
    }

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomNumber(0, 10000);
        }
        //System.out.println("Unsorted array: ");
        //System.out.println(Arrays.toString(array));

        HeapSort hs = new HeapSort();
        hs.sort(array);

        //System.out.print("Heapsort: ");
        //System.out.println(Arrays.toString(array));
        measureTime(() -> hs.sort(array));
    }
}