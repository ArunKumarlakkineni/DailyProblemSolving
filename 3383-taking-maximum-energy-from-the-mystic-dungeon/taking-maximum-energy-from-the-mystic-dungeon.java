class Solution {
    int[] dp;
    public int solve(int[] en,int i,int k){
        if(i>=en.length) return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i]=en[i]+solve(en,i+k,k);
    }
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res = Math.max(res,solve(energy,i,k));
        }
        return res;
    }
}