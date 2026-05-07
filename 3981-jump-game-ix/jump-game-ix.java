class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] rmin = new int[n];
        rmin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            rmin[i] = Math.min(rmin[i+1],nums[i]);
        }
        int[] lmax = new int[n];
        lmax[0] = nums[0];
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1],nums[i]);
        }

        int[] res = new int[n];
        res[n-1] = lmax[n-1];
        for(int i=n-2;i>=0;i--){
            if(lmax[i] > rmin[i+1]){
                res[i] = res[i+1];
            }else{
                res[i] = lmax[i];
            }
        }
        return res;
    }
}