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

    public void solve(String s,int i, int n,StringBuilder temp){
        if(i==n){
            if(isValidParentheses(temp.toString())){
                res.add(temp.toString());
            }
            return;
        }
        for(int j=0;j<s.length();j++){
            temp.append(s.charAt(j));
            solve(s, i+1, n, temp);
            temp.deleteCharAt(temp.length() - 1);

        }

    }
    public List<String> generateParenthesis(int n) {
        String ss = "()";
        solve(ss,0,n*2,new StringBuilder());
        return res;
    }
}