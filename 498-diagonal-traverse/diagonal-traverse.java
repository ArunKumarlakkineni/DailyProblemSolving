class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m*n];
        boolean forward = false;
        res[0] = mat[0][0];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(forward){
                while(i<m-1&&j>0){
                    res[k++]=mat[i++][j--];
                }
                res[k++] = mat[i][j];
                if(i==m-1){
                    j++;
                }else{
                    i++;
                }
                forward = false;
            }else{
                while(i>0&&j<n-1){
                    res[k++]=mat[i--][j++];
                }
                res[k++]=mat[i][j];
                if(j==n-1){
                    i++;
                }else{
                    j++;
                }
                forward = true;
            }
        }
        return res;
    }
}