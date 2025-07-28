class Solution {
    public int solve(int[] nums,int or,int i,int por){
        if(i == nums.length)return por == or?1:0;
        
        return solve(nums,or,i+1,por|nums[i])+solve(nums,or,i+1,por);
        
    }
    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res |= nums[i];
        }
        return solve(nums,res,0,0);
    }
}