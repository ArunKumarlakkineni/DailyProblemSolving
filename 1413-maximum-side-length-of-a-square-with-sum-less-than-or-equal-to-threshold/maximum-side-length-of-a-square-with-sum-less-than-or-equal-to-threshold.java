class Solution {
    public boolean check(int[][] mat, int threshold, int mid) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i + mid - 1 < m; i++) {
            for (int j = 0; j + mid - 1 < n; j++) {
                int r2 = i + mid - 1;
                int c2 = j + mid - 1;

                int sum = mat[r2][c2];
                if (i > 0) sum -= mat[i - 1][c2];
                if (j > 0) sum -= mat[r2][j - 1];
                if (i > 0 && j > 0) sum += mat[i - 1][j - 1];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        // In-place prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) mat[i][j] += mat[i - 1][j];
                if (j > 0) mat[i][j] += mat[i][j - 1];
                if (i > 0 && j > 0) mat[i][j] -= mat[i - 1][j - 1];
            }
        }
        int l = 1,r = Math.min(m,n);
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(check(mat,threshold,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}