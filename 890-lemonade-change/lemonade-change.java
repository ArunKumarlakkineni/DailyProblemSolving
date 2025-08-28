class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] ff = new int[21];
        ff[5]=ff[10]=ff[20]=0;
        int n=bills.length;
        if(n==1){
            return bills[0]!=5?false:true;
        }
        ff[bills[0]]++;
        for(int i=1;i<n;i++){
           if(bills[i]==10){
                if(ff[bills[i]-5]>0){
                    ff[bills[i]]++;
                    ff[bills[i]-5]--;
                }else{
                    return false;
                }
           }else if(bills[i]==20){
                if(ff[bills[i]-15]>0&&ff[bills[i]-10]>0){
                    ff[bills[i]]++;
                    ff[bills[i]-15]-=1;
                    ff[bills[i]-10]-=1;
                }else if(ff[bills[i]-15]>=3){
                    ff[bills[i]]++;
                    ff[bills[i]-15]-=3;
                }else{
                    return false;
                }
           }else{
                ff[bills[i]]++;
           }
        }
        return true;
    }
}