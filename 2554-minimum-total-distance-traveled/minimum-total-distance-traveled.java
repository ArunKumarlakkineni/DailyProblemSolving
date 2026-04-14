class Solution {
    long[][] dp;

    public long solve(List<Integer> robot, List<Integer> slots, int i, int j) {
        if (i == robot.size()) return 0;
        if (j == slots.size()) return (long)1e15; // invalid

        if (dp[i][j] != -1) return dp[i][j];

        // Option 1: assign robot[i] to slot[j]
        long take = Math.abs(robot.get(i) - slots.get(j)) 
                    + solve(robot, slots, i + 1, j + 1);

        // Option 2: skip this slot
        long skip = solve(robot, slots, i, j + 1);

        return dp[i][j] = Math.min(take, skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)-> Integer.compare(a[0],b[0]));
        // expand factories into slots
        List<Integer> slots = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                slots.add(f[0]);
            }
        }

        dp = new long[robot.size()][slots.size()];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(robot, slots, 0, 0);
    }
}