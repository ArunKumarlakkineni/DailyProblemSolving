class Solution {
    public int solve(int[] nums,int l,int r){
        int prev = nums[l];
        int prevPrev = Math.max(nums[l],nums[l+1]);
        int res = Math.max(prev,prevPrev);
        for(int i=l+2;i<r;i++){
            res = Math.max(nums[i]+prev,prevPrev);
            prev = prevPrev;
            prevPrev = res;
        }
        return res;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(solve(nums,0,n-1),solve(nums,1,n));
    }
}