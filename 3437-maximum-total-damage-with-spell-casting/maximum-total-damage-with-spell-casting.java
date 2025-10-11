class Solution {
    Map<Integer, Integer> freqMap = new HashMap<>();
    long[] dp;
    public static int lowerBound(int[] arr, int fromIndex, int toIndex, int target) {
        int index = Arrays.binarySearch(arr, fromIndex, toIndex, target);
        if (index < 0) {
            index = -index - 1;
        }
        return index; // returns position within full array range
    }
    public long solve(int[] pow,int i){
        if(i>=pow.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        //skip
        long skip = solve(pow,i+1);

        //take
        int j = lowerBound(pow,i+1,pow.length,pow[i]+3);
        long take = (long)pow[i]*freqMap.get(pow[i]) + solve(pow,j);
        return dp[i] = Math.max(skip,take);
    }
    public long maximumTotalDamage(int[] power) {
        dp = new long[power.length+1];
        Arrays.fill(dp,-1);
        for (int num : power) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] keysArray = freqMap.keySet()
                                 .stream()
                                 .sorted()
                                 .mapToInt(Integer::intValue)
                                 .toArray();
                        
        return solve(keysArray,0);
    }
}