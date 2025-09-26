class Solution {
    public boolean isTriangle(int x,int y,int z){
        return ((x+y)>z)&&((y+z)>x)&&((z+x)>y);
    }
    public int triangleNumber(int[] nums) {
        int n = nums.length,res=0;
        Arrays.sort(nums);
        for(int i=n-1;i>=0;i--){
            int left = 0,right=i-1;
            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    res+= (right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}