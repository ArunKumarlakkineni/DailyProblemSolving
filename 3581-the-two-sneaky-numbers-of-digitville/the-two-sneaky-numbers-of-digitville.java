class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];
        int j =0;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            if(mp.get(nums[i])==2){
                res[j++]=nums[i];
            }
        }
        return res;
    }
}