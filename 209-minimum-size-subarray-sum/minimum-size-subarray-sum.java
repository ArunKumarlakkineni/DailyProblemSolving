class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0,r=0;
        int psum = 0;
        int res = Integer.MAX_VALUE;
        while(r<n){
            psum+=nums[r];
            while(psum>=target){
                res = Math.min(res,r-l+1);
                psum-=nums[l];
                l++;
            }
            r++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}