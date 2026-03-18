class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length,n = grid[0].length;
        for(int i=1;i<n;i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i=1;i<m;i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] += (grid[i-1][j]+grid[i][j-1]-grid[i-1][j-1]);
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<=k){
                    res++;
                }
            }
        }
        return res;
    }
}