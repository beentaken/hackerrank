package hackerrank.algorithms;

public class CountGridPaths {


    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

//        int[][] grid = new int[][]{
//                {0, 0, 1},
//                {0, 0, 0},
//        };


        System.out.println(countpaths(grid, 0, 0, new int[grid.length][grid[0].length]));
    }

    private static int countpaths(int[][] grid, int row, int column, int[][] memo) {

        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return 1;
        }

        if (row >= grid.length || column >= grid[0].length) {
            return 0;
        }

        if (grid[row][column] == 1) {
            return 0;
        }

        if (memo[row][column] == 0) {

            memo[row][column] = countpaths(grid, row + 1, column, memo) +
                    countpaths(grid, row, column + 1, memo);
        }

        return memo[row][column];
    }
}
