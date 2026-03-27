class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length,n = mat[0].length;
        k%=n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr = j;
                int futureIndex = 0;
                if(i%2==0) futureIndex = (j+k)%n;
                else futureIndex = (j-k+n)%n;

                if(mat[i][curr]!=mat[i][futureIndex]) return false;
            }
        }
        return true;
    }
}