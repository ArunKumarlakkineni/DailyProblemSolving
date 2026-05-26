class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqs = new int[26];
        int[] freqc = new int[26];
        for(int i=0;i<word.length();i++){
            int ch = word.charAt(i)-'a';
            int chc = word.charAt(i)-'A';
            if(ch>=0 && ch<26){
                freqs[ch]++;
            }else{
                freqc[chc]++;
            }
        }
        int cn = 0;
        for(int i=0;i<26;i++){
            if(freqs[i]>0 && freqc[i]>0){
                cn++;
            }
            
        }
        return cn;
    }
}