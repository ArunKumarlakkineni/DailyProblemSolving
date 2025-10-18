class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int last = Integer.MIN_VALUE; // last assigned value

        for (int num : nums) {
            // The minimum we can use for this element
            int val = Math.max(last + 1, num - k);
            if (val <= num + k) {
                count++;
                last = val;
            }
        }

        return count;
    }
}