class Solution {
    public boolean bs(int[] nums,int x){
        int l = 0,r = nums.length-1;
        if(nums.length==1) return nums[0]==x; 
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==x){
                return true;
            }else if(nums[mid]>x){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;

        for(int i=0;i<n;i++){
            if(bs(nums2,nums1[i])){
                return nums1[i];
            }
        }
        return -1;
    }
}