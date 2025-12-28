class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            int l=0,r=n-1;
            int ans = -1;
            while(l<=r){
                int mid = (l+r)/2;
                if(grid[i][mid]<0){
                    ans = mid;
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            res+= ans!=-1?(n-ans):0;
        }
        return res;
    }
}