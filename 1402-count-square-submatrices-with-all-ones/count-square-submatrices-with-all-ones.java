class Solution {
    
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(
                        matrix[i-1][j], 
                        Math.min(matrix[i][j-1], matrix[i-1][j-1])
                    );
                    res += matrix[i][j];
                }
                
            }
        }
        for (int i=0;i<m;i++) {
            res+=matrix[i][0];
        }

        for (int i=1;i<n;i++) {
            res+=matrix[0][i];
        }

        return res;
        
    }
}