class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] d = new int[n];
        int MOD = 1000000007;
        d[0]=1;
        for(int i=0;i<n;i++){
            if(d[i]!=0){
                // System.out.println(i+"___"+d[i]);
                if(i+delay<n){
                    int st=i+delay;
                    int en = i+forget>n?n:i+forget;
                    for(int j=st;j<en;j++){
                        d[j]= (d[j]+d[i])%MOD;
                    }
                }
            }
        }
        for(int i=forget-1;i<n-1;i++){
            
            d[i-forget+1]=0;
        }
        int people = 0;
        for(int i=0;i<n;i++){
            people=(people+d[i])%MOD;
        }
        return people;
    }
}