class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        // Map: value -> list of indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: group indices by their value
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Step 2: examine each value that appears at least 3 times
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                // Only check consecutive triples
                for (int idx = 0; idx < indices.size() - 2; idx++) {
                    int i = indices.get(idx);       // first index
                    int k = indices.get(idx + 2);   // third index
                    // distance = 2 * (k - i)  (middle index j is irrelevant)
                    int distance = 2 * (k - i);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}