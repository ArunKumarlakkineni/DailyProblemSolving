class Solution {
    public StringBuilder addOne(StringBuilder s) {
        int n = s.length();
        int carry = 1;   // because we are adding 1
        
        for (int i = n - 1; i >= 0; i--) {
            if (carry == 0) break;
            
            if (s.charAt(i) == '0') {
                s.setCharAt(i, '1');
                carry = 0;   // no more carry
            } else {
                s.setCharAt(i, '0');
                carry = 1;   // carry continues
            }
        }
        
        if (carry == 1) {
            s.insert(0, '1');
        }
        
        return s;
    }

    public int numSteps(String s) {
        int n = s.length();
        int res = 0;
        StringBuilder sb = new StringBuilder(s);
        while(!(sb.length() == 1 && sb.charAt(0) == '1')){
            if(sb.charAt(sb.length()-1)=='1'){
                sb = addOne(sb);
            }else{
                sb.deleteCharAt(sb.length() - 1);
            }
            res++;
        }
        return res;
    }
}