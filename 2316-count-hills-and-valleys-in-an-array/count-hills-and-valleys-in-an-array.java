class Solution {
    public int countHillValley(int[] nums) {
        int res = 0,n = nums.length;
        int left = 0;
        for(int i=1;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                if((nums[i]>nums[left]&&nums[i]>nums[i+1])||
                    (nums[i]<nums[left]&&nums[i]<nums[i+1])){
                        res++;
                    }
                    left = i;
            }
        }
        return res;
    }
}