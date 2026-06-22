class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch: text.toCharArray()){
            freq[ch-'a']++;
        }
        int mnc = Integer.MAX_VALUE;
        for(char ch:"balon".toCharArray()){
            mnc = (ch=='b' || ch=='a' || ch=='n') ? Math.min(mnc,freq[ch-'a']): Math.min(mnc,freq[ch-'a']/2);
        }
        return mnc;
    }
}