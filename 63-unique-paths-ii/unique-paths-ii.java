class Solution {
    int[][] dp;
    int m,n;
    public int dfs(int[][] grid,int i,int j){
        if(i==m-1 && j==n-1 && grid[i][j]!=1){
            return 1;
        }
        if(i<m && j<n && grid[i][j]==1)return 0;
        if(i>m||j>n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int paths = 0;
        int down = dfs(grid,i+1,j);
        int right = dfs(grid,i,j+1);
        return dp[i][j] = down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(obstacleGrid,0,0);
    }
}