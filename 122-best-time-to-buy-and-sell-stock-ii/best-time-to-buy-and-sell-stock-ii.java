class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int mn = prices[0];
        for(int i=1;i<n;i++){
            mn = Math.min(mn,prices[i]);
            if(prices[i]>mn){
                res += (prices[i]-mn);
                mn = prices[i];
            }
        }
        return res;
    }
}