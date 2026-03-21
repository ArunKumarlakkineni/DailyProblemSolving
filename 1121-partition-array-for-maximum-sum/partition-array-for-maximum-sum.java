class Solution {
    int[] dp;
    public int solve(int[] arr, int k, int i) {
        if (i == arr.length) return 0;

        if (dp[i] != -1) return dp[i];

        int max = 0;
        int maxSum = 0;

        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            max = Math.max(max, arr[j]);
            int len = j - i + 1;

            int sum = max * len + solve(arr, k, j + 1);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(arr,k,0);
    }
}