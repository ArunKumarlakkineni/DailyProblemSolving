class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int por = -1;
            for(int j=1;j<=nums.get(i);j++){
                if((j|(j+1))==nums.get(i)){
                    por = j;
                    break;
                }
            }
            res[i] = por;
        }
        return res;
    }
}