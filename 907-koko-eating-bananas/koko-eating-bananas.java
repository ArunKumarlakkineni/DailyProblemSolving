class Solution {
    public boolean check(int[] piles,long mid,int h){
        int hr = 0;
        int eats = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=mid){
                hr++;
            }else{
                if(piles[i]%mid==0){
                    hr+=(piles[i]/mid);
                }else{
                    hr+=(piles[i]/mid)+1;
                }
            }
        }
        return hr<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long l = 1;
        long r = Arrays.stream(piles).asLongStream().sum();
        long ans = -1;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(check(piles,mid,h)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)ans;
    }
}