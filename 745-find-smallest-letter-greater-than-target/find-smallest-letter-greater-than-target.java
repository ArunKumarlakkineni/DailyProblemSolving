class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        if(res>target) return res;
        int l=1,r=letters.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(letters[mid]>target){
                res = letters[mid];
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
}