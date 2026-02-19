class Solution {
    public int countBinarySubstrings(String s) {
        int cur = 1;
        int prev = 0;
        int res = 0;
        int n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cur++;
            }else{
                res += Math.min(cur,prev);
                prev = cur;
                cur = 1;
            }
        }
        return res+Math.min(cur,prev);
    }
}