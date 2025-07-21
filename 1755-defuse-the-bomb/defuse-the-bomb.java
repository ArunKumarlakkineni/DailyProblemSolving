class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k==0){
            for(int i=0;i<n;i++){
                res[i] = 0;
            }
        }else if(k>0){
            int psum = 0;
            for(int i=1;i<=k;i++){
                psum += code[i%n];
            }
            res[0] = psum;
            for(int i=1;i<n;i++){
                psum = psum+code[(i+k)%n]-code[i];
                res[i] = psum; 
            }
        }
        else if(k<0){
            int psum = 0;
            int ck = Math.abs(k);
            int i = 0;
            while(ck>0){
                psum+=code[(((i-1%n)+n)%n)];
                i--;
                ck--;
            }
            int kk = Math.abs(k);
            res[0] = psum;
            for(int j=1;j<n;j++){
                psum = code[j-1]+psum-code[(((j-1-kk)+n)%n)%n];
                res[j] = psum;
            }
        }
        return res;
    }
}