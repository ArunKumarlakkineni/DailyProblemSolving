class Solution {
    public boolean judgeCircle(String moves) {
        int vc = 0,vr = 0;
        for(char ch:moves.toCharArray()){
            if(ch=='R'){
                vr++;
            }else if(ch=='L'){
                vr--;
            }else if(ch=='U'){
                vc--;
            }else if(ch=='D'){
                vc++;
            }
        }
        return vc==0 && vr==0;
    }
}