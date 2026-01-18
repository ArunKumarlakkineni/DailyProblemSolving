class Solution {
    public boolean check(int[][] grid,int i,int j,int k){
        int psum = 0;
        for(int sj = j; sj < j + k; sj++){
            psum += grid[i][sj];
        }
        for(int si=i;si<(i+k);si++){
            int csum = 0;
            for(int sj=j;sj<(j+k);sj++){
                csum+=grid[si][sj];
            }
            if(csum!=psum) return false;
        }
        for(int sj=j;sj<(j+k);sj++){
            int csum = 0;
            for(int si=i;si<(i+k);si++){
                csum+=grid[si][sj];
            }
            if(csum!=psum) return false;
        }
        int csi=i,csj=j;
        int csum=0;
        //cross sum
        while(csi<(i+k) && csj<(j+k)){
            csum+=grid[csi][csj];
            csi++;
            csj++;
        }
        if(csum!=psum) return false;

        //cross sum reverse
        csi = i;
        csj = (j+k-1);
        csum = 0;
        while(csi<(i+k) && csj>=j){
            csum+=grid[csi][csj];
            csi++;
            csj--;
        }
        if(csum!=psum) return false;
        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int k = Math.min(m,n);
        for(int res=k;res>1;res--){
            for(int i=0;i<=m-res;i++){
                for(int j=0;j<=n-res;j++){
                    if(check(grid,i,j,res)){
                        return res;
                    }
                }
            }
        }
        return 1;
    }
}