class Solution {
    Set<Integer> st = new HashSet<>();
    public boolean isValid(int n){
        if(n<=10){
            if(n==0||n==1 || n==10 || n==8) return false;
            return !st.contains(n);
        }
        int cn = 0;
        int len = 0;
        while(n>0){
            int ld = n%10;
            if(ld==0 || ld==1 || ld==8) cn++;
            if(st.contains(ld)) return false;
            len++;
            n = n/10;
        }
        return cn==len?false:true;
    }
    public int rotatedDigits(int n) {
        st.add(3);
        st.add(4);
        st.add(7);
        int res = 0;
        for(int i=1;i<=n;i++){
            if(isValid(i)){
                res++;
            }
        }
        return res;
    }
}