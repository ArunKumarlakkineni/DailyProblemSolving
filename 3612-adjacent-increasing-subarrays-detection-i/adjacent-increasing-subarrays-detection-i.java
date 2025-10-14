class Solution {
    public boolean isIncreasing(List<Integer> nums,int l,int r){
        System.out.println(l+"----"+r);
        for(int i=l;i<r-1;i++){
            if(nums.get(i)>=nums.get(i+1))return false;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(nums.size()==2||k==1) return true;
        for(int i=0;i<nums.size()-k-1;i++){
            if(i+2*k<=nums.size()&&isIncreasing(nums,i,i+k)&&isIncreasing(nums,i+k,i+2*k)){
                return true;
            }
        }
        return false;
    }
}