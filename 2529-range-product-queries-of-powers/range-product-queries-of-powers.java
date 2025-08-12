class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int)(1e9+7);
        List<Integer> pow = new ArrayList<>();
        int q = queries.length;
        for(int i=0;i<31;i++){
            if((n >> i&1) == 1)pow.add(1<<i);
        }
        int[] res = new int[q];
        for(int i=0;i<q;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;
            for(int j=left;j<=right;j++){
                product = (product*pow.get(j)) % MOD;
            }
            res[i] = (int)product;
        }
        return res;
    }
    
}