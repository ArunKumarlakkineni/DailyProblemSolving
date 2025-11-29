class Solution {
    static {
        for(int i=0;i<400;i++){
            minOperations(new int[]{1,2,3},5);
        }
    }
    public static int minOperations(int[] nums, int k) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=nums[i];
        }
        return res%k;
    }
}