class Solution {
    int[][] dp;
    int offset;

    public int solve(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + offset] != -1) {
            return dp[i][sum + offset];
        }

        int add = solve(nums, i + 1, sum + nums[i], target);
        int sub = solve(nums, i + 1, sum - nums[i], target);

        return dp[i][sum + offset] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) total += Math.abs(n);

        offset = total;
        dp = new int[nums.length][2 * total + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(nums, 0, 0, target);
    }
}
