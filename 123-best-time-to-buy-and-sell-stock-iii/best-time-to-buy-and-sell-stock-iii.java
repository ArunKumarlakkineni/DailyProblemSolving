class Solution {
    int[][][] dp;
    public int solve(int[] prices,int buy,int k,int in){
        if(k == 0) return 0;
        if(in == prices.length) return 0;
        if(dp[in][buy][k]!=-1) return dp[in][buy][k];
        if(buy==1){
            return dp[in][buy][k] = Math.max(-prices[in]+solve(prices,0,k,in+1),
                                solve(prices,1,k,in+1));
        }else{
            return dp[in][buy][k] = Math.max(prices[in]+solve(prices,1,k-1,in+1),
                                solve(prices,0,k,in+1));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(prices,1,2,0);
    }
}