class Solution {
    public boolean check(int[][] mat,int threshold,int mid){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<=m-mid;i++){
            for(int j=0;j<=n-mid;j++){
                int psum = 0;
                boolean notValid = false;
                for(int sqi=i;sqi<(i+mid);sqi++){
                    for(int sqj=j;sqj<(j+mid);sqj++){
                        psum+=mat[sqi][sqj];
                        if(psum>threshold){
                            notValid = true;
                            break;
                        }
                    }
                }
                if(!notValid){
                    return true;
                }
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
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