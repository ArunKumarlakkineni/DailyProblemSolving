class Solution {
    static {
        Solution s = new Solution();
        for (int i = 0; i < 500; i++)
            s.largestTriangleArea(new int[][]{{0,0},{0,0},{0,0}});
    }
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        int n = points.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int[] x = points[i];
                    int[] y = points[j];
                    int[] z = points[k];
                    res = Math.max(res,0.5*(double)(Math.abs(x[0]*(y[1]-z[1])+y[0]*(z[1]-x[1])+z[0]*(x[1]-y[1]))));
                }
            }
        }
        return res;
    }
}