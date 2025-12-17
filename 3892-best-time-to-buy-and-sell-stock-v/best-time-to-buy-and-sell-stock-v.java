class Solution {
    public long helper(int[] prices, int k, Long[][][] dp, int i, int state){
        if(i == prices.length || k == 0){
            if(state == 0){ //reached end or transactions finished and we are not holding any stock
                return 0;
            } else{ //if state is 1 or 2 means we are holding any stock, but since we cannot complete the transaction, so give a -ve answer so that this stock answer is never considered
                return (long)-1e18;
            }
        }
        
        if(dp[i][k][state] != null){
            return dp[i][k][state];
        }

        // 0 -> not holding any stock
        if(state == 0){
            long skip = helper(prices, k, dp, i + 1, state);
            long buy = helper(prices, k, dp, i + 1, 1) - prices[i]; // (sell - buy) = profit, so buy kia means -ve add kr do and sell kia toh +ve add kro
            long sell = helper(prices, k, dp, i + 1, 2) + prices[i];
            return dp[i][k][state] = Math.max(Math.max(skip, buy), sell);
        } else if(state == 1){ // 1 -> bought a stock. waiting to sell
            long skip = helper(prices, k, dp, i + 1, state);
            long sell = helper(prices, k - 1, dp, i + 1, 0) + prices[i];
            return dp[i][k][state] = Math.max(skip, sell);
        } else{ //2 -> sold a stock. waiting to buyback
            long skip = helper(prices, k, dp, i + 1, state);
            long buy = helper(prices, k - 1, dp, i + 1, 0) - prices[i];
            return dp[i][k][state] = Math.max(skip, buy);
        }
    }
    public long maximumProfit(int[] prices, int k) {
        Long[][][] dp = new Long[prices.length + 1][k + 1][3];
        return helper(prices, k, dp, 0, 0);
    }
}