class Solution {
    List<List<String>> res = new ArrayList<>();
    public boolean check(int r,int c,char[][] board){
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q')return false;
        }
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        for(int i=r-1,j=c+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
    public void solve(char[][] board,int i){
        if(i==board.length){
            List<String> temp = new ArrayList<>();
            for(int t=0;t<board.length;t++){
                String st = new String(board[t]);
                temp.add(st);
            }
            res.add(temp);
            return;
        }
        for(int st=0;st<board.length;st++){
            if(check(i,st,board)){
                board[i][st]='Q';
                solve(board,i+1);
                board[i][st]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(board,0);
        return res;
    }
}