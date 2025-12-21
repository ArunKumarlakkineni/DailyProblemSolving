class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int pfSum = 0;
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            pfSum+=nums[i];
            int rem = pfSum%k;
            if(mp.containsKey(rem)){
                int in = i-mp.get(rem);
                if(in>=2){
                    return true;
                }
            }else{
                mp.put(rem,i);
            }
            
        }
        return false;
    }
}