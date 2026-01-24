class Solution {
    public int minPairSum(int[] nums) {
        int tot = Arrays.stream(nums).sum();
        int n = nums.length;
        int maxSum = tot/(n/2);
        Arrays.sort(nums);
        int l = 0,r = n-1;
        int res = 0;
        while(l<r){
            res = Math.max(res,nums[l]+nums[r]);
            l++;
            r--;
        }
        return res;
    }
}