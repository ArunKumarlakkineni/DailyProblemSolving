class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return 0;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        res = Math.min(res,(nums[k-1]-nums[0]));
        for(int i=k;i<n;i++){
            res = Math.min(res,(nums[i]-nums[i-k+1]));
        }
        return res;
    }
}