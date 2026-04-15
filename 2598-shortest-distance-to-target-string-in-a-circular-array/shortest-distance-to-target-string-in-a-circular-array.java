class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        int n = words.length;
        if(words[startIndex].equals(target)) return 0;
        for(int i=startIndex;i<startIndex+words.length;i++){
            if(words[(i+1)%n].equals(target)){
                res = Math.min(res,i-startIndex+1);
                System.out.println(res);
            }
        }
        for(int i=startIndex;i>startIndex-n;i--){
            if(words[(i-1+n)%n].equals(target)){
                res = Math.min(res,startIndex-i+1);
                System.out.println(res);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}