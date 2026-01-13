class Solution {
    public boolean check(int[][] squares,double mid,double total){
        double bottomArea = 0.00000;
        for(int[] sq:squares){
            double x = sq[0];
            double y = sq[1];
            double l = sq[2];
            double topY = y+l;
            if(mid > topY){
                bottomArea+=(l*l);
            }else if(mid>y){
                bottomArea+=((mid-y)*l);
            }
        }
        return bottomArea>=total/2.0;
    }
    public double separateSquares(int[][] squares) {
        double totalArea = 0.00000;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for(int[] sq:squares){
            double x = sq[0];
            double y = sq[1];
            double l = sq[2];
            totalArea+=(l*l);
            low = Math.min(low,y);
            high = Math.max(high,y+l);
        }
        double ans = 0.00000;
        while((high-low)>1e-5){
            double mid = low+(high-low)/2;
            ans = mid;
            if(check(squares,mid,totalArea)){
                high = mid;
            }else{
                low = mid;
            }
        }
        return ans;
    }
}