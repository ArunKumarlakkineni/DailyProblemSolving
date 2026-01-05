class Solution {
    public int maxElementIndex(int[][] arr,int m,int mid){
        int res = Integer.MIN_VALUE;
        int in = -1;
        for(int i=0;i<m;i++){
            if(res<arr[i][mid]){
                res = arr[i][mid];
                in = i;
            }
        }
        return in;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l=0,r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int maxEi = maxElementIndex(mat,m,mid);
            int mx = mat[maxEi][mid];
            int left = mid-1>=0?mat[maxEi][mid-1]:-1;
            int right = mid+1<n?mat[maxEi][mid+1]:-1;
            if(mx>left && mx>right){
                return new int[]{maxEi,mid};
            }else if(mx<left){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}