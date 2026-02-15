class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int pad = 0;
        int rem = Math.max(n1,n2);
        String tempA = "",tempB = "";
        if(n1<n2){
            pad = rem - n1;
            for(int i=0;i<pad;i++){
                tempA+='0';
            }
        }else if(n1>n2){
            pad = rem - n2;
            for(int i=0;i<pad;i++){
                tempB+='0';
            }
        }
        tempA+=a;
        tempB+=b;
        int carry = 0;
        String res = "";
        for(int i=rem-1;i>=0;i--){
            if(tempA.charAt(i)=='1' && tempB.charAt(i)=='1' && carry==1){
                res+="1";
                carry = 1;
            }else if(tempA.charAt(i)=='1' && tempB.charAt(i)=='1' && carry==0){
                res+="0";
                carry = 1;
            }else if (tempA.charAt(i)=='0' && tempB.charAt(i)=='1' && carry==1){
                res+="0";
                carry = 1;
            }else if(tempA.charAt(i)=='1' && tempB.charAt(i)=='0' && carry==1){
                res+="0";
                carry=1;
            }else if(tempA.charAt(i)=='0' && tempB.charAt(i)=='0' && carry==1){
                res+="1";
                carry = 0;
            }else if(tempA.charAt(i)=='0' && tempB.charAt(i)=='0' && carry==0){
                res+="0";
                carry = 0;
            }else if(tempA.charAt(i)=='0' && tempB.charAt(i)=='1' && carry==0){
                res+="1";
                carry = 0;
            }else if(tempA.charAt(i)=='1' && tempB.charAt(i)=='0' && carry==0){
                res+="1";
                carry = 0;
            }
        }
        if(carry==1){
            return new StringBuilder(res+"1").reverse().toString();
        }
        return new StringBuilder(res).reverse().toString();
    }
}