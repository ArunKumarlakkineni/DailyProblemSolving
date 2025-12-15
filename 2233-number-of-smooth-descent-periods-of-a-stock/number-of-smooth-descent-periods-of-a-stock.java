class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 0L;
        int prev = prices[0];
        long cn = 1;
        for(int i=1;i<n;i++){
            if(prev == prices[i]+1){
                cn++;
                
            }else{
                res+=(long)((cn)*(cn+1))/2;
                cn=1;
            }
            prev = prices[i];
        }
        res+=(long)((cn)*(cn+1))/2;;
        return res;
    }
}