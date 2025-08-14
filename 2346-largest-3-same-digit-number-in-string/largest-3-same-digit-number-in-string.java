class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        int n =num.length();
        for(int i=0;i<n;i++){
            if(i+2<n && (num.charAt(i)==num.charAt(i+1))
            && (num.charAt(i)==num.charAt(i+2))){
                if(res.equals("")){
                    res = num.substring(i,i+3);
                }else {
                    if(Integer.parseInt(res)<Integer.parseInt(num.substring(i,i+3))){
                        res = num.substring(i,i+3);
                    }
                }
            }
        }
        return res;
    }
}