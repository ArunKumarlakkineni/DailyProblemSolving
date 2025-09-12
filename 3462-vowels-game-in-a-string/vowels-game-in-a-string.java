class Solution {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean doesAliceWin(String s) {
        int res = 0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                res++;
            }
        }
        if(res==0)return false;
        return true;
    }
}