class Solution {
    public boolean isValid(String s1,String s2){
        int i=0,j=0;
        int n1 = s1.length(),n2 = s2.length();
        if(n2-n1!=1) return false;
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==n1;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] t = new int[n];
        Arrays.fill(t,1);
    
        int maxLIS = 1;
        Arrays.sort(words, (a,b)->a.length()-b.length());
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isValid(words[j],words[i])) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }

        return maxLIS;
    }
}