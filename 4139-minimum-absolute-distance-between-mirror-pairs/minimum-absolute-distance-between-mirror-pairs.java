class Solution {
    public int reverse(int num){
        return Integer.parseInt(new StringBuilder(num+"").reverse().toString());
    }
    public int minMirrorPairDistance(int[] nums) {
        int res = 100000, i = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int n : nums) {
            if (seen.containsKey(n))
                res = Math.min(res, i - seen.get(n));

            

            seen.put(reverse(n), i++);
        }

        return res == 100000 ? -1 : res;
    }
}