class Solution {
    int[][] dp = new int[51][51];
    public int solve(int[] values,int i,int j){
        if(j-i+1<3)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int wt = values[i]*values[k]*values[j]
                        +solve(values,i,k)+solve(values,k,j);
            res = Math.min(res,wt);
        }
        return dp[i][j]=res;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        for (int i = 0; i < 51; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(values,0,n-1);
    }
}