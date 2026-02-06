class Solution {
    
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l=0,r=0;
        int res = 0;
        while(r<n){
            while(nums[r]>(long)nums[l]*k){
                l++;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return n-res;
    }
}