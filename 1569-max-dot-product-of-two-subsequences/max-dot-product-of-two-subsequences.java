class Solution {
    int[][] dp;

    int solve(int[] a, int[] b, int i, int j) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE / 2;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int pick = a[i] * b[j] + Math.max(0, solve(a, b, i-1, j-1));
        int skipA = solve(a, b, i-1, j);
        int skipB = solve(a, b, i, j-1);

        return dp[i][j] = Math.max(pick, Math.max(skipA, skipB));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return solve(nums1, nums2, n-1, m-1);
    }
}