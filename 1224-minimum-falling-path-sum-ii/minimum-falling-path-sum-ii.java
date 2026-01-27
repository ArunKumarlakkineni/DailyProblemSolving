class Solution {
    int[][] dp;

    public int solve(int[][] mat, int i, int j) {
        // column bounds
        if (j < 0 || j >= mat[0].length) return Integer.MAX_VALUE;

        // last row
        if (i == mat.length - 1) return mat[i][j];

        // memo
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        // choose any column except j in next row
        for (int k = 0; k < mat[0].length; k++) {
            if (k != j) {
                int next = solve(mat, i + 1, k);
                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, mat[i][j] + next);
                }
            }
        }

        return dp[i][j] = ans;
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, solve(matrix, 0, j));
        }

        return res;
    }
}
