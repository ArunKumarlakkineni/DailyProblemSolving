class Solution {
    int rr = 0;
    public void solve(int[] nums,int or,int i,int por){
        if(i>nums.length) return;
        if(por==or){
            rr += (1<<(nums.length-i));
            return;
        }
        
        for(int j=i;j<nums.length;j++){
            solve(nums,or,j+1,por|nums[j]);
        }
        
    }
    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res |= nums[i];
        }
        solve(nums,res,0,0);
        return rr;
    }
}