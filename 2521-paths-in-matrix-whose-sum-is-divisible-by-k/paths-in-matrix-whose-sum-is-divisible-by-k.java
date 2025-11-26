class Solution {
    int mod = 1000000007;
    Integer[][][] dp;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        dp = new Integer[m][n][k]; // memo

        return dfs(grid, k, 0, 0, 0);
    }

    private int dfs(int[][] grid, int k, int i, int j, int sumMod) {
        int m = grid.length, n = grid[0].length;

        if (i >= m || j >= n) return 0;

        int newMod = (sumMod + grid[i][j]) % k;

        // If at end cell
        if (i == m - 1 && j == n - 1) {
            return newMod == 0 ? 1 : 0;
        }

        // memo check
        if (dp[i][j][newMod] != null) {
            return dp[i][j][newMod];
        }

        long right = dfs(grid, k, i, j + 1, newMod);
        long down  = dfs(grid, k, i + 1, j, newMod);

        long ans = (right + down) % mod;
        dp[i][j][newMod] = (int) ans;
        return dp[i][j][newMod];
    }
}
