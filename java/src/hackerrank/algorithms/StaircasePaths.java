package hackerrank.algorithms;

public class StaircasePaths {

    //number of paths up a staircase using recursion.


    public static int countPathsR(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }
        return countPathsR(steps - 1) + countPathsR(steps - 2) + countPathsR(steps - 3);
    }

    public static int countPathsMemo(int steps) {
        return countPathsMemo(steps, new int[steps + 1]);
    }

    public static int countPathsMemo(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }
        if (memo[steps] == 0) {
            memo[steps] = countPathsMemo(steps - 1, memo) +
                    countPathsMemo(steps - 2, memo) +
                    countPathsMemo(steps - 3, memo);
        }
        return memo[steps];
    }

    public static int countPathsDP(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps <= 1) {
            return 1;
        }
        int[] paths = new int[steps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++) {
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];

        }
        return paths[steps];
    }

    public static void main(String[] args) {
//        System.out.println(countPathsR(100));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(countPathsMemo(50));
        System.out.println(countPathsDP(10));
    }

}
