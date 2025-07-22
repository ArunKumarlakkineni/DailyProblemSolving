class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int pres = 0;
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int l = 0, r = 0;
        while(r<n){
            if(!st.contains(nums[r])){
                st.add(nums[r]);
                pres += nums[r];
                res = Math.max(res,pres);
                r++;
            }else{
                pres -= nums[l];
                st.remove(nums[l]);
                l++;
            }
        }
        return res;
    }
}