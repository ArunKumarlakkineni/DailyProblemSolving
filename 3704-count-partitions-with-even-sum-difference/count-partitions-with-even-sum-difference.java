class Solution {
    public int countPartitions(int[] nums) {
        int tot = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            tot+=nums[i];
        }
        int res = 0;
        int lsum = 0;
        for(int i=0;i<n-1;i++){
            lsum += nums[i];
            tot -= nums[i];
            if((lsum-tot)%2==0){
                res++;
            }
        }
        return res;
    }
}