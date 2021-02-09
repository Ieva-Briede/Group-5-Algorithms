public class Main {

    public static int[] getRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return array;
    }

    public static void main(String[] args) {

        int[] generalArray = getRandomArray(20000, 0, 20000);
        int[] arrForQuicksort= generalArray.clone();
        int[] arrForInsertionSort=generalArray.clone();
        int[] arrForHeapsort=generalArray.clone();


        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(arrForQuicksort, 0, arrForQuicksort.length - 1);
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Quicksort execution time: "+elapsed);

        startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(arrForInsertionSort);
        elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Insertion sort execution time: "+elapsed);

        startTime = System.currentTimeMillis();
        HeapSort.sort(arrForHeapsort);
        elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Heapsort execution time: "+elapsed);
    }
}
