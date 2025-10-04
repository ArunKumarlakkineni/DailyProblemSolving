class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int l=0,r=n-1;
        while(l<r){
            int maxC = Math.min(height[l],height[r]);
            res = Math.max(res,maxC*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}