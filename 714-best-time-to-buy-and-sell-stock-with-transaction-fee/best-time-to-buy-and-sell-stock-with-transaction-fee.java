class Solution {
    int[][] dp;
    public int solve(int[] prices, int buy,int in,int fee){
        if(in>=prices.length) return 0;
        if(dp[in][buy]!=-1) return dp[in][buy];
        if(buy==1){
            return dp[in][buy] = Math.max(-prices[in]+solve(prices,0,in+1,fee),
                                solve(prices,1,in+1,fee));
        }else{
            return dp[in][buy] = Math.max(prices[in]-fee+solve(prices,1,in+1,fee),
                                solve(prices,0,in+1,fee));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices,1,0,fee);
    }
}