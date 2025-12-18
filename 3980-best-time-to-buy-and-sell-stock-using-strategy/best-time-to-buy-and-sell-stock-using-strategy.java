class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long res = 0;
        int n = prices.length;
        long[] mul = new long[n];
        long[] pf = new long[n];
        mul[0] = prices[0]*strategy[0];
        pf[0] = Math.abs(prices[0]);
        for(int i=1;i<n;i++){
            mul[i] = mul[i-1]+(prices[i]*strategy[i]);
            pf[i] = pf[i-1]+Math.abs(prices[i]);
        }
        long pres = 0;
        res = mul[n-1];
        for(int i=0;i<=n-k;i++){
            long left = (i > 0) ? mul[i - 1] : 0;
            pres+=left;
            int mid = i + k / 2;
            long midSum = pf[i + k - 1] - (mid > 0 ? pf[mid - 1] : 0);
            pres+=midSum;
            pres+=mul[n-1]-mul[i+k-1];
            res = Math.max(res,pres);
            pres=0;
        }
        return res;
    }
}