class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i =0;
        while(i<n-1){
            if(bits[i]==1){
                i++;
            }
            i++;
        }
        return i!=n;
    }
}