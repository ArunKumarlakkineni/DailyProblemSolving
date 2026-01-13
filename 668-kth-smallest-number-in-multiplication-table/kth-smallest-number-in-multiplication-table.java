class Solution {
    public int lessThanK(int m,int n,int mid){
        int sum = 0;
        for(int i=1;i<=m;i++){
            sum+=Math.min((mid/i),n);
        }
        return sum;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(lessThanK(m,n,mid)<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}