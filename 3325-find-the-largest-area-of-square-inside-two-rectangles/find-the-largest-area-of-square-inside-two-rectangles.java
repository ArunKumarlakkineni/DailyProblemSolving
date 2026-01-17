class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long res = 0;
        int n = bottomLeft.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long x2 = Math.min(topRight[i][0],topRight[j][0]);
                long x1 = Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                long width = x2-x1;
                long y2 = Math.min(topRight[i][1],topRight[j][1]);
                long y1 = Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                long height = y2-y1;
                res = Math.max(res,Math.min(height,width));
            }
        }
        
        return res*res;
    }
}