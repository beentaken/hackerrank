package hackerrank.sorting;

import java.util.Arrays;

public class TwoPointerTechnique {


    public static void main(String[] args) {
        int[] indices = findSumEquals(7,
                new int[]{1, 2, 3, 4, 5, 7},
                new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(indices));
    }

    private static int[] findSumEquals(int x, int[] a, int[] b) {

        int i = 0;
        int j = b.length - 1;

        while (i < a.length) {
            while (a[i] + b[j] > x && j > 0) j--;
            if (a[i] + b[j] == x) return new int[]{i, j};
            i++;
        }
        return null;
    }


}
