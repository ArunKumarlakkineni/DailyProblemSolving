class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            Set<Integer> ste = new HashSet<>();
            Set<Integer> sto = new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j]%2==0){
                    ste.add(nums[j]);
                }else {
                    sto.add(nums[j]);
                }
                if(ste.size()==sto.size()){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}