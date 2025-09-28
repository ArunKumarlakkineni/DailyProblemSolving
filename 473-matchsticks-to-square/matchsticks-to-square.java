class Solution {
    public boolean solve(int[] ma,int[] ss,int in,int side){
        if(in==ma.length)return true;
        for(int i=0;i<4;i++){
            if(ma[in]+ss[i]<=side){
                ss[i]+=ma[in];
                if(solve(ma,ss,in+1,side)){
                    return true;
                }
                ss[i]-=ma[in];
            }
            if(ss[i]==0){
                break;
            }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int tsum = 0;
        for(int m:matchsticks) tsum+=m;
        if(tsum%4!=0)return false;
        int side = tsum/4;
        int[] ss = new int[4];
        return solve(matchsticks,ss,0,side);
    }
}