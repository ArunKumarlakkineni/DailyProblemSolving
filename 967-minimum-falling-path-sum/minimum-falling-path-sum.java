class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                int down = dp[i + 1][j];
                int dl = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int dr = (j < n - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(dl, dr));
            }
        }
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[0][j]);
        }
        return res;
    }
}