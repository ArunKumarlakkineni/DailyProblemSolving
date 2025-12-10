class Solution {
    private static int MOD = 1000000007;
    public int perm(int n){
        if(n==1||n==2)return n;
        long res=1;
        for(int i=n;i>=1;i--){
            res=(res*i)%MOD;
        }
        return (int)res;
    }
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int mn = Arrays.stream(complexity).min().getAsInt();
        long count = Arrays.stream(complexity)
                   .filter(x -> x == mn)
                   .count();
        if(count!=1||mn!=complexity[0]|| complexity[0]==complexity[1])return 0;
        return perm(n-1);
    }
}