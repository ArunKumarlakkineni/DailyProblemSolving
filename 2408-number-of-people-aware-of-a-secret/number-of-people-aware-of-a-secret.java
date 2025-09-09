class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];  
        dp[0] = 1;

        long shareablePeople = 0; 

        for (int day = 1; day < n; day++) {
            if (day - delay >= 0) {
                shareablePeople = (shareablePeople + dp[day - delay]) % MOD;
            }
            if (day - forget >= 0) {
                shareablePeople = (shareablePeople - dp[day - forget] + MOD) % MOD;
            }

            dp[day] = shareablePeople;
        }

        long total = 0;
        for (int i = n - forget; i < n; i++) {
            total = (total + dp[i]) % MOD;
        }

        return (int) total;
    }
}