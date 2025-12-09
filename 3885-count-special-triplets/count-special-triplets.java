class Solution {
    private static final int MOD = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long res = 0;

        Map<Integer, Long> left = new HashMap<>();
        Map<Integer, Long> right = new HashMap<>();

        // Build right frequency map
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0L) + 1);
        }

        for (int j = 0; j < n; j++) {
            // Move nums[j] from right to middle
            long cnt = right.get(nums[j]) - 1;
            if (cnt == 0) right.remove(nums[j]);
            else right.put(nums[j], cnt);

            int target = 2 * nums[j];

            if (left.containsKey(target) && right.containsKey(target)) {
                long ways = (left.get(target) * right.get(target)) % MOD;
                res = (res + ways) % MOD;
            }

            // Move nums[j] to left
            left.put(nums[j], left.getOrDefault(nums[j], 0L) + 1);
        }

        return (int) res;
    }
}