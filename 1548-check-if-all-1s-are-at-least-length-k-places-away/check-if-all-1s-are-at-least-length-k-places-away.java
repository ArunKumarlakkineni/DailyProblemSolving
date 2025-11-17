class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1 && prev==-1){
                prev=i;
            }else if(nums[i]==1){
                if((i-prev)>=k+1){
                    prev = i;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}