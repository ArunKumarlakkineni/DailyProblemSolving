class Solution {
    double dp[][];
    public double solve(int poured,int i,int j){
        if(i<0 || j<0 || i<j) return 0;

        if(i==0&&j==0) return poured;
        if(dp[i][j]!=-1) return dp[i][j];
        double upLeft = (solve(poured,i-1,j-1)-1)/2.0;
        double upRight = (solve(poured,i-1,j)-1)/2.0;

        if(upLeft<0) upLeft = 0;
        if(upRight<0) upRight = 0;

        return dp[i][j] = upLeft+upRight;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[101][101];
        for(int i=0;i<101;i++) Arrays.fill(dp[i],-1);
        return Math.min(1,solve(poured,query_row,query_glass));

    }
}