class Solution {
    public int countCollisions(String directions) {
        char[] s = directions.toCharArray();
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(int i=0;i<directions.length();i++){
            if(!st.isEmpty() && st.peek()=='R'&& s[i]=='L'&& i>0){
                res+=2;
                st.pop();
                while(!st.isEmpty() && st.peek()=='R'){
                    res++;
                    st.pop();
                }
                st.push('S');
            }else if(!st.isEmpty() &&st.peek()=='S' && s[i]=='L'){
                res++;
                st.pop();
                st.push('S');
            }else if(!st.isEmpty() && st.peek()=='R' && s[i]=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    res++;
                    st.pop();
                }
                st.push('S');
            }else{
                st.push(s[i]);
            }
        }
        return res;
    }
}