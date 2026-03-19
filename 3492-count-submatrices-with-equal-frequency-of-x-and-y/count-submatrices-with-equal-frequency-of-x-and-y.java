class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int cx = 0,cy = 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] tempx = new int[m][n];
        int[][] tempy = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tempx[i][j] = grid[i][j]=='X'?1:0;
                tempy[i][j] = grid[i][j]=='Y'?1:0;
                if(i-1>=0){
                    tempx[i][j] += tempx[i-1][j];
                    tempy[i][j] += tempy[i-1][j];
                }
                if(j-1>=0){
                    tempx[i][j] += tempx[i][j-1];
                    tempy[i][j] += tempy[i][j-1];
                }
                if(i-1>=0 && j-1>=0){
                    tempx[i][j] -= tempx[i-1][j-1];
                    tempy[i][j] -= tempy[i-1][j-1];
                }

                if(tempx[i][j]==tempy[i][j] && tempx[i][j]>0){
                    res++;
                }
            }
        }
        return res;
    }
}