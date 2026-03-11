class Solution {
    public int bitwiseComplement(int n) {
        int in = 1;
        int res = 0;
        if(n==0) return 1;
        while(n!=0){
            if(n%2==0){
                res += in;
            }
            in*=2;
            n/=2;
        }
        return res;
    }
}