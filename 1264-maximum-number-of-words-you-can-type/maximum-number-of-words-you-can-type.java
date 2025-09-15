class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int res = 0;
        
        for(String word: words){
            boolean check = false;
            for(char ch: word.toCharArray()){
                if(brokenLetters.indexOf(ch)!=-1){
                    check = true;
                    break;
                }
            }
            if(!check){
                res++;
            }
        }
        return res;
    }
}