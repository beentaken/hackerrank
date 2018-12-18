package hackerrank.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
                System.out.println(Arrays.toString(array));
            }
            lastUnsorted--;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 10, 5, 9, 8};
        bubblesort(ints);
        System.out.println(Arrays.toString(ints));
    }


}
