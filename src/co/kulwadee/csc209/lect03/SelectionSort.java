package co.kulwadee.csc209.lect03;
import java.text.DecimalFormat;

public class SelectionSort {
    /**
     * Swaps the elements at index i and j.
     */
    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Finds the index of the lowest value
     * starting from the index at start (inclusive)
     * and going to the end of the array.
     */
    public static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    /**
     * Sorts the elements (in place) using selection sort.
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {  
            int j = indexLowest(array, i);        // n + n-1 + n-2 + .. + 1 = n(n+1)/2
            swapElements(array, i, j);            // n 
        }
    }

    public static int randInteger(int min, int max) {
        return min + (int)(Math.random() * (max-min) + 1);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static long testSelectionSort(int[] array) {
        long startTime, endTime;
        startTime = System.nanoTime();
        selectionSort(array);
        endTime   = System.nanoTime();
        return endTime - startTime;
    }
    public static double nanoToSeconds(long ns) {
        return ns * 10E-9;
    }

    public static String formatDecimal(double d) {
        DecimalFormat df = new DecimalFormat("#.#####");
        return df.format(d);
    }

    public static void main(String[] args) {
        int min = 1, max = 100;
        int[] numElements = {16, 32, 64, 128, 256, 512, 1024};

        for (int k = 0; k < numElements.length; k++) {
            int arraySize = numElements[k];
            // init. a random array of arraySize integers
            int[] A = new int[arraySize];
            for (int i = 0; i < A.length; i++) {
                A[i] = randInteger(min, max);
            }
            // run the selection sorting
            long duration = testSelectionSort(A);
            // print stat
            System.out.println(arraySize + ": " + formatDecimal(nanoToSeconds(duration)));
        }

    }
}
