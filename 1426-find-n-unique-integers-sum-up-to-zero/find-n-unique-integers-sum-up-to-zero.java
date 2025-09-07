class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if(n==0) return res;
        if(n%2==0){
            int k=0;
            for(int i=-(n/2);i<=n/2;i++){
                if(i==0)continue;
                res[k++]=i;
            }
        }else{
            int k=0;
            for(int i=-(n/2);i<=n/2;i++){
                res[k++]=i;
            }
        }
        return res;
    }
}