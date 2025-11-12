class Solution {
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;

        // Step 1: Count 1s
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) return n - ones;  // We can convert others to 1

        // Step 2: Find shortest subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i);
                    break; // no need to continue; smaller subarray possible
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1; // No subarray with gcd = 1
        return minLen + (n - 1);
    }
}