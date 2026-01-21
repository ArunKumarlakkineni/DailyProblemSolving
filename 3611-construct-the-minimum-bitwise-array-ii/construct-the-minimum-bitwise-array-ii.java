class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int por = -1;
            int x = nums.get(i);

            // count trailing 1s
            int t = 0;
            int temp = x;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }

            // if no trailing 1s, no solution
            if (t == 0) {
                por = -1; // or whatever you want
            } else {
                int k = t - 1;
                por = x - (1 << k);
            }
            res[i] = por;
        }
        return res;
    }
}