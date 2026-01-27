class Solution {
    int[][] dp;
    int m, n;

    public int dfs(int[][] grid, int i, int j) {
       if (i >= m || j >= n) return Integer.MAX_VALUE;

        // Destination cell
        if (i == m - 1 && j == n - 1) return grid[i][j];

        // Memoization
        if (dp[i][j] != -1) return dp[i][j];

        int down = dfs(grid, i + 1, j);
        int right = dfs(grid, i, j + 1);

        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(grid,0,0);
    }
}