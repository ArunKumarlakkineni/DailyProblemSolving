class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        // int prev  = nums[0];
        int l=0,r=n;
        while(l<r){
            // int prev = nums[l];
            for(int i=0;i<r-1;i++){
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            r--;
        }
        return nums[0];
    }
}