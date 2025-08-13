class Solution {
    Map<String,Integer> mp = new HashMap<>();
    int MOD = 1000000007;
    public int solve(int n,int x,int pi,int psum){
        String key = pi + "i" + psum;
        if (mp.containsKey(key)) return mp.get(key);

        if (psum == n) return 1;
        if (psum > n || Math.pow(pi, x) > n - psum) return 0;

        int res = solve(n, x, pi + 1, psum + (int) Math.pow(pi, x)) %MOD
                + solve(n, x, pi + 1, psum)%MOD;
        mp.put(key, res%MOD);

        return res%MOD;

    }
    public int numberOfWays(int n, int x) {
        return solve(n,x,1,0);
    }
}