class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = Arrays.stream(grid)
                   .flatMapToInt(Arrays::stream)
                   .asLongStream()
                   .sum();

        if (total % 2 != 0) return false;

        long half = total / 2;

        // 🔹 Check horizontal cuts (top vs bottom)
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == half) return true;
        }

        // 🔹 Check vertical cuts (left vs right)
        long colSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if (colSum == half) return true;
        }

        return false;
    }
}