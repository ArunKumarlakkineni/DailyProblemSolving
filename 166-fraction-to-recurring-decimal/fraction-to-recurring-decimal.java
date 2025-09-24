class Solution {
    
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = ((numerator>0&&denominator<0)||(numerator<0&&denominator>0))?true:false;
        Map<Long,Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long nl = Math.abs((long)numerator);
        long dl = Math.abs((long)denominator);
        long quotient = nl/dl;
        sb.append(quotient);
        nl%=dl;
        if(nl!=0){
            sb.append(".");
        }
        int quotientIndex = 0;
        while(nl!=0){
            nl*=10;
            quotient = Math.abs(nl/dl);
            if(!mp.containsKey(nl)){
                sb.append(quotient);
                mp.put(nl,quotientIndex++);
            }else{
                sb.insert(1+sb.indexOf(".")+mp.get(nl),'(');
                sb.append(")");
                break;
            }
            nl%=dl;
        }
        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}