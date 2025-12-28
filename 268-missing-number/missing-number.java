class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tot = Arrays.stream(nums).sum();
        int tot_sum = (n*(n+1))/2;
        return tot_sum-tot;
    }
}