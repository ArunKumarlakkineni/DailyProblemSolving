class Solution {
    private long prefix(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        long power = 1;  // 4^(k-1)
        int k = 1;       // step count
        
        while (power <= n) {
            long left = power;
            long right = Math.min(4 * power - 1, n);
            long count = right - left + 1;
            
            sum += count * (long)k;
            
            power *= 4;
            k++;
        }
        
        return sum;
    }
    public long minOperations(int[][] queries) {
        long total = 0;
        
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            
            long sumSteps = prefix(r) - prefix(l - 1);
            long ops = (sumSteps + 1) / 2; // ceil division
            
            total += ops;
        }
        
        return total;
    }
}