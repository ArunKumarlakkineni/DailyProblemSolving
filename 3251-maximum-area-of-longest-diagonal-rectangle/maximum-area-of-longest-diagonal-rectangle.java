class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double res = 0;
        int area = 0;
        int n = dimensions.length;
        for(int i=0;i<n;i++){
            int sq = dimensions[i][0]*dimensions[i][0] +
                        dimensions[i][1]*dimensions[i][1];
            if(Math.sqrt(sq)>res){
                res = Math.sqrt(sq);
                area = dimensions[i][0]*dimensions[i][1];
            }else if(Math.sqrt(sq)==res){
                int pa = dimensions[i][0]*dimensions[i][1];
                if(pa>area){
                    res = Math.sqrt(sq);
                    area = pa;
                }
            }
        }
        return area;
    }
}