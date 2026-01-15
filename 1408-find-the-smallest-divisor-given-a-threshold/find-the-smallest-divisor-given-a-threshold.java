class Solution {
    public boolean check(int[] nums,long div,int thres){
        long tot =0;
        for(int i=0;i<nums.length;i++){
            tot+= (nums[i]%div==0)?(nums[i]/div) : (nums[i]/div)+1;
        }
        return tot<=thres;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        long low = 1;
        long high = Arrays.stream(nums).asLongStream().sum();
        long ans =0;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(check(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)ans;
    }
}