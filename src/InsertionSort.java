import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("execution time: " + elapsed + " ms");
    }

    public static void main(String a[]){
        int[] arr1 = new int [10000];
        for (int i =0; i < arr1.length; i++){
            arr1[i] = getRandomNumber(0, 10000);
        }
        //System.out.println("Before Insertion Sort");
        //for(int i:arr1){
           // System.out.print(i+" ");
       //}
        //System.out.println();

        measureTime(() ->insertionSort(arr1));//sorting array using insertion sort

       //System.out.println("Insertion Sort");
        //for(int i:arr1){
          // System.out.print(i+" ");
       // }
        //System.out.println();
        //measureTime(() ->insertionSort(arr1));
    }
}


