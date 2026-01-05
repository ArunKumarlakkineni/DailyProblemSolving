class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg = 0;
        int n = matrix.length;
        long sum=0;
        int mn = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                int absV = Math.abs(matrix[i][j]);
                sum+=Math.abs(absV);
                mn = Math.min(mn,absV);
            }
        }
        return neg%2==0 ? sum: sum-2*mn;
    }
}