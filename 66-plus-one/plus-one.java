class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length,carry=0;
        for(int i=n-1;i>=0;i--){
            int digs;
            if(i==n-1){
                digs = (digits[i]+1);
            }else{
                digs = digits[i]+carry;
            }
            
            carry = digs/10;
            digits[i] = digs%10;
            if(carry ==0) return digits;
        }
        if(carry!=0){
            int[] res1 = new int[n+1];
            for(int i=n;i>=1;i--){
                res1[i] = digits[i-1];
            }
            res1[0] = carry;
            return res1;
        }
        return digits;
    }
}