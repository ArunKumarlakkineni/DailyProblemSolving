class Solution {
    boolean checkSquare(int[][] mat,int n,int sti,int stj){
        int mul = 1;
        if(sti+n > mat.length||stj+n > mat[0].length) return false;
        for(int i=sti;i<sti+n;i++){
            for(int j=stj;j<stj+n;j++){
                mul *= mat[i][j];
                if(mul==0) return false;
            }
        }
        return true;
    }
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    res++;
                }
            }
        }
        for(int si=2;si<=m;si++){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    
                    if(matrix[i][j]==1 && checkSquare(matrix,si,i,j)){
                        res++;
                    }
                }
            }
        }
        return res;
        
    }
}