class Solution {
    int MOD = 1000000007;
    int[][][] dp = new int[201][201][2];
    int solve(int ol,int zl,int lastOne,int lim){
        if(ol==0 && zl==0) return 1;
        if(dp[zl][ol][lastOne]!=-1) return dp[zl][ol][lastOne];
        int res = 0;
        if(lastOne==1){
            for(int len=1;len<=Math.min(lim,zl);len++){
                res = (res+solve(ol,zl-len,0,lim))%MOD;
            }
        }else{
            for(int len=1;len<=Math.min(lim,ol);len++){
                res = (res+solve(ol-len,zl,1,lim))%MOD;
            }
        }
        return dp[zl][ol][lastOne] = res;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int i=0;i<201;i++){
            for(int j=0;j<201;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int f1 = solve(zero,one,1,limit);
        int f2 = solve(zero,one,0,limit);
        return (f1+f2)%MOD;
    }
}