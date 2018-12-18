package hackerrank.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeChange {

    private static int makeChange(int[] coins, int money) {
//        return makeChange(coins, money, 0);
        return makeChange(coins, money, 0, new HashMap<>());
    }

    private static int makeChange(int[] coins, int money, int index) {
        System.out.println(String.format("%s %d %d", Arrays.toString(coins), money, index));
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        // amount we have used with this particular coin
        int amountWithCoin = 0;
        int ways = 0;

        while(amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange(coins, remaining, index + 1);
            amountWithCoin += coins[index];
        }
        return ways;
    }

    private static int makeChange(int[] coins, int money, int index, Map<String, Integer> memo) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }

        String key = money + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // amount we have used with this particular coin
        int amountWithCoin = 0;
        int ways = 0;

        while(amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
        }

        memo.put(key, ways);

        return ways;
    }

    public static void main(String[] args) {
        System.out.println(makeChange(new int[]{1, 2, 5, 10}, 12));
    }

}
