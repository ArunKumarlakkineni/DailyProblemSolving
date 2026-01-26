class Solution {
    
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int prev = nums[0];
        int prevPrev = Math.max(nums[0],nums[1]);
        int res = Math.max(prev,prevPrev);
        for(int i=2;i<n;i++){
            res = Math.max(nums[i]+prev,prevPrev);
            prev = prevPrev;
            prevPrev = res;
        }
        return res;
    }
}