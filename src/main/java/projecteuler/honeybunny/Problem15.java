package projecteuler.honeybunny;

/**
 * Lattice paths
 * Problem 15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the
 * right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15 {

    public static void main(String[] args) {
        // a grid of 20x20 actually has 21 vertices, which are represented by each cell in the array
        long[][] grid = new long[21][21];
        System.out.println(getAllCombinationsHelper(grid, 0, 0));
    }

    private static long getAllCombinationsHelper(long[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 0;
        }

        if (grid[i][j] > 0) {
            return grid[i][j];
        }

        if (i == grid.length - 1) {
            return 1;
        }

        if (j == grid.length - 1) {
            return 1;
        }

        grid[i][j] = getAllCombinationsHelper(grid, i + 1, j) + getAllCombinationsHelper(grid, i, j + 1);

        return grid[i][j];
    }

}