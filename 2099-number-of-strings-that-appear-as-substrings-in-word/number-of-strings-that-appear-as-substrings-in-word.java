class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String a:patterns){
            if(word.contains(a)){
                res++;
            }
        }
        return res;
    }
}