class Solution {
    public boolean check(int[] nums,int div,int thres){
        int tot =0;
        for(int i=0;i<nums.length;i++){
            tot+= (nums[i]%div==0)?(nums[i]/div) : (nums[i]/div)+1;
        }
        return tot<=thres;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}