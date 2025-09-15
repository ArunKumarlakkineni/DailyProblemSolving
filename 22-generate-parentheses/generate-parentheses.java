class Solution {
    List<String> res = new ArrayList<>();
    public boolean isValidParentheses(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false; // More ')' than '('
                }
            }
        }
        return balance == 0; // All opened '(' are closed
    }

    public void solve(String s,int i, int n,String temp){
        if(i==n){
            if(isValidParentheses(temp)){
                res.add(temp);
            }
            return;
        }
        for(int j=0;j<s.length();j++){
            temp+=s.charAt(j);
            solve(s,i+1,n,temp);
            temp=temp.substring(0,temp.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        String ss = "()";
        solve(ss,0,n*2,"");
        return res;
    }
}