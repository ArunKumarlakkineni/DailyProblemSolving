class Solution {
    public int solve(int[] nums,int ts,int i,int sum){
        if(ts==sum && i==nums.length) return 1;
        if(i>=nums.length) return 0;
        int pos = solve(nums,ts,i+1,sum+nums[i]);
        int neg = solve(nums,ts,i+1,sum-nums[i]);
        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int tot = Arrays.stream(nums).sum();
        int ts = tot-target;
        return solve(nums,target,0,0);
    }
}