package hackerrank.algorithms;

import java.util.Arrays;

public class IceCreamParlor {

    // Find a the indices of a pair of values that add up to a query value.



    private static int indexOf(int[] menu, int value, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
    }

    private static int[] findChoices(int[] menu, int money) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] a = getIndicesFromValues(menu, sortedMenu[i], complement);
                System.out.println(a[0] + " " + a[1]);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] c = findChoices(new int[]{1, 3, 5, 6, 7, 9, 11}, 10);
        assert Arrays.equals(c, new int[]{0, 5});
    }



}
