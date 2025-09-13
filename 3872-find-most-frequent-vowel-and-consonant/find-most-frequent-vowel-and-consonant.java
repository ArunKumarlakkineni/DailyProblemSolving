class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxV=0,maxC=0;
        for(int i=0;i<26;i++){
            if(i==0||i==4||i==8||i==14||i==20){
                maxV = Math.max(maxV,freq[i]);
            }else{
                maxC = Math.max(maxC,freq[i]);
            }
        }
        return maxV+maxC;
    }
}