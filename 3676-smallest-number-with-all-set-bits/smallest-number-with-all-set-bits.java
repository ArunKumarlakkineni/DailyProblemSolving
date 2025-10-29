class Solution {
    public int smallestNumber(int n) {
        int pn = 1;
        int temp = pn;
        while(temp<n){
            pn = pn*2;
            temp = pn-1;
        }
        return temp;
    }
}