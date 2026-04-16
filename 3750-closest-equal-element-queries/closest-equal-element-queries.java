class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,Set<Integer>> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.putIfAbsent(nums[i],new TreeSet<>());
            mp.get(nums[i]).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int q:queries){
            TreeSet<Integer> set = (TreeSet)mp.get(nums[q]);

            if (set.size() <= 1) {
                res.add(-1);
                continue;
            }

            // Remove current index temporarily
            set.remove(q);

            Integer higher = set.ceiling(q);
            Integer lower = set.floor(q);

            int minDist = Integer.MAX_VALUE;

            // check higher
            if (higher != null) {
                int d = Math.abs(higher - q);
                minDist = Math.min(minDist, Math.min(d, n - d));
            } else {
                // wrap around → first element
                int d = Math.abs(set.first() - q);
                minDist = Math.min(minDist, Math.min(d, n - d));
            }

            // check lower
            if (lower != null) {
                int d = Math.abs(lower - q);
                minDist = Math.min(minDist, Math.min(d, n - d));
            } else {
                // wrap around → last element
                int d = Math.abs(set.last() - q);
                minDist = Math.min(minDist, Math.min(d, n - d));
            }

            res.add(minDist);

            // add back
            set.add(q);
            
        }
        return res;
    }
}