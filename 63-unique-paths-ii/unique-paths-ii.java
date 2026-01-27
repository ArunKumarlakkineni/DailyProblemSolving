class Solution {
    int[][] dp;
    int m, n;

    public int dfs(int[][] grid, int i, int j) {
        // 1. Out of bounds
        if (i >= m || j >= n) return 0;

        // 2. Obstacle
        if (grid[i][j] == 1) return 0;

        // 3. Destination
        if (i == m - 1 && j == n - 1) return 1;

        // 4. Memoization
        if (dp[i][j] != -1) return dp[i][j];

        int down = dfs(grid, i + 1, j);
        int right = dfs(grid, i, j + 1);

        return dp[i][j] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(obstacleGrid, 0, 0);
    }
}
