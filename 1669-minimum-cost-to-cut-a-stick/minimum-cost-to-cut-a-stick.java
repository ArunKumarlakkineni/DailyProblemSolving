class Solution {
    int[][] dp;
    int solve(int st,int en,int[] cuts,int i,int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int minCut = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            minCut = Math.min(minCut,
                    solve(st,cuts[k],cuts,i,k-1)+solve(cuts[k],en,cuts,k+1,j)
                    + (en-st));
        }
        return dp[i][j] = minCut;
    }
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        dp = new int[size+1][size+1];
        for(int i=0;i<size+1;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(cuts);
        return solve(0,n,cuts,0,size-1);
    }
}