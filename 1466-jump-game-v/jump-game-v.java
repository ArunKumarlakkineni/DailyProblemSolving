class Solution {
    public int dfs(int[] arr,int[] dp,int i,int d){
        if(dp[i]!=0) return dp[i];

        int mx = 1;
        int n = arr.length;
        for(int j=1;j<=d && i+j<n;j++){
            if(arr[i]>arr[i+j]){
                mx = Math.max(mx,1+dfs(arr,dp,i+j,d));
            }else break;
        }
        for(int j=1;j<=d && i-j>=0;j++){
            if(arr[i]>arr[i-j]){
                mx = Math.max(mx,1+dfs(arr,dp,i-j,d));
            }else break;
        }
        return dp[i]=mx;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dfs(arr,dp,i,d));
        }
        return ans;
    }
}