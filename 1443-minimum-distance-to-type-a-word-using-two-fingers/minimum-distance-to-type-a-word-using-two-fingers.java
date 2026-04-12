class Solution {
    Integer[][][][][] dp;
    public int solve(char[] word,int i,int f1i,int f1j,int f2i,int f2j){
        if(i==word.length) return 0;
        if (dp[i][f1i+1][f1j+1][f2i+1][f2j+1] != null)
            return dp[i][f1i+1][f1j+1][f2i+1][f2j+1];
        int x = (word[i] - 'A') / 6;
        int y = (word[i] - 'A') % 6;

        int useF1 = 0, useF2 = 0;

        // Use finger 1
        if (f1i == -1) {
            useF1 = solve(word, i+1, x, y, f2i, f2j);
        } else {
            int dist = Math.abs(f1i - x) + Math.abs(f1j - y);
            useF1 = dist + solve(word, i+1, x, y, f2i, f2j);
        }

        // Use finger 2
        if (f2i == -1) {
            useF2 = solve(word, i+1, f1i, f1j, x, y);
        } else {
            int dist = Math.abs(f2i - x) + Math.abs(f2j - y);
            useF2 = dist + solve(word, i+1, f1i, f1j, x, y);
        }
        return dp[i][f1i+1][f1j+1][f2i+1][f2j+1] = Math.min(useF1, useF2);
    }
    public int minimumDistance(String word) {
        dp = new Integer[word.length()][7][7][7][7];
        return solve(word.toCharArray(),0,-1,-1,-1,-1);
    }
}