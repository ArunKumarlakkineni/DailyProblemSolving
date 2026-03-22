class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int c90=0,c180=0,c270=0,c0=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(target[i][j]==mat[n-j-1][i])
                    c90++;
                if(target[i][j]==mat[n-i-1][n-j-1])
                    c180++;
                if(target[i][j]==mat[j][n-i-1])
                    c270++;
                if(target[i][j]==mat[i][j])
                    c0++;
            }
        }
        if(c90==n*n||c270==n*n||c180==n*n||c0==n*n)
        return true;
        else return false;
    }
}