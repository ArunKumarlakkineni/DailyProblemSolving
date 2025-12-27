class Solution {
    boolean bfs(int[] arr,int x){
        int l=0,r=arr.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==x){
                return true;
            }else if(arr[mid]>x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(target<=matrix[i][n-1]){
                return bfs(matrix[i],target);
            }
        }
        return false;
    }
}