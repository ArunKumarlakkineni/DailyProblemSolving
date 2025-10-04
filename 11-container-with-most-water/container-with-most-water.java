class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int l=0,r=n-1;
        while(l<r){
            int minC = Math.min(height[l],height[r]);
            res = Math.max(res,minC*(r-l));
            while (l<r && height[l] <= minC) {
                l++;
            }
            while (l<r && height[r] <= minC) {
                r--;
            }
        }
        return res;
    }
}