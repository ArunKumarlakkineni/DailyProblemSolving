class Solution {
    int dp[][];
    public int solve(String s1,String s2,int n1,int n2){
        if(n1==0 && n2==0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(n1==0 && n2!=0) {
            int s2s = 0;
            for(int k=n2-1;k>=0;k--){
                s2s+=(int)s2.charAt(k);
            }
            return s2s;
        }
        if(n1!=0 && n2==0){
            int s1s = 0;
            for(int k=n1-1;k>=0;k--){
                s1s+=(int)s1.charAt(k);
            }
            return s1s;
        } 
        if(s1.charAt(n1-1)!=s2.charAt(n2-1)){
            int del1 = (int)s1.charAt(n1-1) + solve(s1,s2,n1-1,n2);
            int del2 = (int)s2.charAt(n2-1) + solve(s1,s2,n1,n2-1);
            return dp[n1][n2] = Math.min(del1,del2);
        }
        return dp[n1][n2] = solve(s1,s2,n1-1,n2-1);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        dp = new int[n1+1][n2+1];
        for(int i=0;i<n1+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s1,s2,n1,n2);
    }
}