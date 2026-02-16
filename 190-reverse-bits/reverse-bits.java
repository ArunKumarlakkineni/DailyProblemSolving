class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        int in = 0;
        while(in<32){
            if(((n>>in)&1)==1){
                System.out.println(in);
                rev += Math.pow(2,31-in);
            }
            in++;
        }
        return (int)rev;
    }
}