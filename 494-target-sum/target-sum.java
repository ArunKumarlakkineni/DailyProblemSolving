class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int solve(int[] nums,int in,int target,int cursum){
        if(in<0 && target == cursum){
            return 1;
        }
        if(in<0){
            return 0;
        }
        String key = in + "," + cursum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int pos = solve(nums,in-1,target,cursum+nums[in]);
        int neg = solve(nums,in-1,target,cursum-nums[in]);
        memo.put(key, pos + neg);
        return memo.get(key);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,nums.length-1,target,0);
    }
}