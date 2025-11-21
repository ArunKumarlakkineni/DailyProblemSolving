class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> st = new HashSet<>();
        int n = s.length();
        int res = 0;
        for(int i=0;i<n;i++){
            st.add(s.charAt(i));
        }
        for(Character ch: st){
            int li = -1,ri = -1;
            for(int i=0;i<n;i++){
                if(ch == s.charAt(i)){
                    if(li == -1){
                        li = i;
                    }
                    ri = i;
                }
            }
            Set<Character> sc = new HashSet<>();
            for(int mi = li+1;mi<=ri-1;mi++){
                sc.add(s.charAt(mi));
            }
            res+=sc.size();
        }
        return res;
    }
}