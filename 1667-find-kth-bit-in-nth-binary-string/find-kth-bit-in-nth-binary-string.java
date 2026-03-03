class Solution {
    StringBuilder invert(StringBuilder sb){
        int n = sb.length();
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'1');
            }else{
                sb.setCharAt(i,'0');
            }
        }
        return sb;
    }
    StringBuilder reverse(StringBuilder sb){
        return sb.reverse();
    }
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder psub = new StringBuilder(sb);
            sb = sb.append("1");
            sb = sb.append(reverse(invert(psub)));
        }
        return sb.charAt(k-1);
    }
}