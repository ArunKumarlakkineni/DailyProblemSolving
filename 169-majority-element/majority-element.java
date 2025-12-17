class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count==0){
                maj=nums[i];
            }
            if(maj==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return maj;
    }
}