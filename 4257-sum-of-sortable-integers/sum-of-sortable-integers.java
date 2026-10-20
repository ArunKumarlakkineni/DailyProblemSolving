class Solution {
    public boolean isSortedRotate(int[] nums,int l,int r){
        int n = r-l+1;
        int cn = 0;
        int[] copy = Arrays.copyOfRange(nums,l,r+1);
        for(int i=0;i<n;i++){
            if(copy[i]> copy[(i+1)%n]){
                cn++;
                if(cn>1){
                    break;
                }
            }
        }
        return cn<=1;
    }
    public boolean check(int[] nums,int k){
        int n = nums.length;
        if(k==1) {
            for(int i=0;i<n-1;i++){
                if(nums[i]>nums[i+1]) return false;
            }
            return true;
        }
        if(k==n){
            return isSortedRotate(nums,0,n-1);
        }
        int cur_mn=Integer.MAX_VALUE,cur_mx=Integer.MIN_VALUE;
        int prev_mn = 0,prev_mx = 0;
        for(int i=0;i<n;i++){
            cur_mn = Math.min(cur_mn,nums[i]);
            cur_mx = Math.max(cur_mx,nums[i]);
            if((i+1)%k==0){
                if(prev_mx>cur_mn) return false;
                prev_mn = cur_mn;
                prev_mx = cur_mx;
                if(!isSortedRotate(nums,i-k+1,i)){
                    return false;
                }
                cur_mn = Integer.MAX_VALUE;
                cur_mx = Integer.MIN_VALUE;
            }
        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                divisors.add(i);
                if(n/i != i){
                    divisors.add(n/i);
                }
            }
        }
        for(int i:divisors){
            if(check(nums,i)){
                ans += i;
            }
        }
        return ans;
    }
}