class Solution {
    int[][] dp;
    int solve(String s1,String s2,int n1,int n2){
        if(n1==0 || n2==0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        int take = Integer.MIN_VALUE/2;
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            take = 1+solve(s1,s2,n1-1,n2-1);
        }
        int skip = Math.max(solve(s1,s2,n1-1,n2),solve(s1,s2,n1,n2-1));
        return dp[n1][n2] = Math.max(take,skip);
        
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        String rev = new StringBuilder(s).reverse().toString();
        return n-solve(s,rev,n,n);
    }
}