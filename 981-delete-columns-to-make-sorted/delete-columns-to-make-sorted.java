class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int n = strs.length;
        int n1 = strs[0].length();
        for(int i=0;i<n1;i++){
            boolean fl = false;
            for(int j=0;j<n-1;j++){
                if(strs[j].charAt(i)-'a' > strs[j+1].charAt(i)-'a'){
                    fl = true;
                }
            }
            if(!fl) res++;
        }
        return n1-res;
    }
}