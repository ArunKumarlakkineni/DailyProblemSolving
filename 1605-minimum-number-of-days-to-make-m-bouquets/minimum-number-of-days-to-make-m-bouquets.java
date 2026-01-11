class Solution {
    public boolean check(int[] arr,int m,int k,int mid){
        int i=0;
        int kk = k;
        int n = arr.length;
        while(i<n){
            while(i<n && arr[i]<=mid && k>0){
                k--;
                i++;
            }
            if(k==0){
                m--;
                k=kk;
            }else{
                k=kk;
                i++;
            }
            
        }
        return m<=0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k)>bloomDay.length) return -1;
        int ans = -1;
        int n = bloomDay.length-1;
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();
        while(l<=r){
            int mid = l+(r-l)/2;
            if(check(bloomDay,m,k,mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}