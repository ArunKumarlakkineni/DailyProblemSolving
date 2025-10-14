class Solution {
    public boolean isIncreasing(List<Integer> nums,int l,int r){
        for(int i=l;i<r;i++){
            if(nums.get(i)>=nums.get(i+1))return false;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        
        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasing(nums, i, i + k - 1) &&
                isIncreasing(nums, i + k, i + 2 * k - 1)) {
                return true;
            }
        }
        
        return false;
    }
}