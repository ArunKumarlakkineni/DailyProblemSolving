class Solution {
    int[][] dp;
    public int solve(int[][] mat,int i,int j){
        if(j<0|| i>=mat.length||j>=mat.length) return Integer.MAX_VALUE;
        if(i==mat.length-1) return mat[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int down = solve(mat,i+1,j);
        int dl = solve(mat,i+1,j-1);
        int dr = solve(mat,i+1,j+1);
        return dp[i][j]=mat[i][j]+Math.min(down,Math.min(dl,dr));
    }
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            res = Math.min(res,solve(matrix,0,i));
        }
        return res;
    }
}