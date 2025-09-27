class Solution {
    public int solve(int[] nums,int in,int target,int cursum){
        if(in<0 && target == cursum){
            return 1;
        }
        if(in<0){
            return 0;
        }
        int pos = solve(nums,in-1,target,cursum+nums[in]);
        int neg = solve(nums,in-1,target,cursum-nums[in]);
        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,nums.length-1,target,0);
    }
}