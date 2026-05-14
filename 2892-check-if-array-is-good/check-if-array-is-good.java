class Solution {
    public boolean isGood(int[] nums) {
        int maxe = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        if(maxe==n) return false;

        int[] cn = new int[maxe+1];

        for(int i:nums){
            cn[i]++;
        }
        for(int i=1;i<maxe;i++){
            if(cn[i]!=1) return false;
        }
        return cn[maxe]==2;
    }
}