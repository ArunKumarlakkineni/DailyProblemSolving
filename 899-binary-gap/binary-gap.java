class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int fir = -1;
        int in = 0;
        while(n!=0){
            if((n&1)==1){
                if(fir==-1){
                    fir = in;
                }else if(fir!=-1){
                    res = Math.max(res,in-fir);
                    fir = in;
                }
            }
            in++;
            n=n/2;
        }
        return res;
    }
}