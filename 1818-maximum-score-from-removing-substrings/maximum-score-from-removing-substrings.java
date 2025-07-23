class Solution {
    int modify(String pat,StringBuilder s,int x){
        int n = s.length();
        if(n<2)return 0;
        StringBuilder ns = new StringBuilder();
        int tot = 0;
        for(int i=0;i<n;i++){
            int nsl = ns.length();
            if(nsl>0 && ns.charAt(nsl-1) == pat.charAt(0)&&
                s.charAt(i) == pat.charAt(1)){
                    ns.deleteCharAt(nsl-1);
                    tot += x;
                }else{
                    ns.append(s.charAt(i));
                }
        }
        s.setLength(0);
        s.append(ns);
        return tot;
    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        StringBuilder cs = new StringBuilder(s);
        int res = 0;
        if(x>y){
            res += modify("ab",cs,x);
            res += modify("ba",cs,y);
        }else{
            res += modify("ba",cs,y);
            res += modify("ab",cs,x);
        }
        return res;
    }
}