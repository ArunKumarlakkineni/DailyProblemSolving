class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for(int i=0;i<queries.length;i++){
            int[] q = queries[i];
            for(int r1=q[0];r1<=q[2];r1++){
                for(int c1=q[1];c1<=q[3];c1++){
                    res[r1][c1]++;
                }
            }
        }
        return res;
    }
}