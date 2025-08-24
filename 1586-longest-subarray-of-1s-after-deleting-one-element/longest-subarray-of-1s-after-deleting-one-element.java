class Solution {
    public int longestSubarray(int[] nums) {
        int l=0,r=0,n=nums.length,res=0;
        int k=1;
        while(r<n){
            if(nums[r]==0){
                k--;
            }
            if(k<0){
                if(nums[l]==0){
                    k++;
                }
                l++;
            }
            res = Math.max(res,r-l);
            r++;
        }
        return res;
    }
}