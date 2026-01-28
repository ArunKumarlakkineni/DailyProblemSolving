import java.util.*;

class Solution {

    public int minCost(int[][] grid, int K) {
        int m = grid.length, n = grid[0].length;
        int INF = (int)1e9;

        // Collect and compress values
        int[] vals = new int[m * n];
        int idx = 0;
        for (int[] row : grid)
            for (int v : row)
                vals[idx++] = v;

        Arrays.sort(vals);
        Map<Integer, Integer> comp = new HashMap<>();
        int id = 0;
        for (int v : vals)
            if (!comp.containsKey(v))
                comp.put(v, id++);

        int V = id;

        int[][][] dp = new int[K + 1][m][n];
        for (int k = 0; k <= K; k++)
            for (int i = 0; i < m; i++)
                Arrays.fill(dp[k][i], INF);

        // Base case
        for (int k = 0; k <= K; k++)
            dp[k][m - 1][n - 1] = 0;

        for (int k = 0; k <= K; k++) {

            // Build teleport helper from dp[k-1]
            int[] best = null;
            if (k > 0) {
                best = new int[V];
                Arrays.fill(best, INF);

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int vid = comp.get(grid[i][j]);
                        best[vid] = Math.min(best[vid], dp[k - 1][i][j]);
                    }
                }

                // prefix minimum
                for (int i = 1; i < V; i++)
                    best[i] = Math.min(best[i], best[i - 1]);
            }

            // Spatial DP (correct order!)
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (i == m - 1 && j == n - 1) continue;

                    int down = (i + 1 < m)
                        ? grid[i + 1][j] + dp[k][i + 1][j]
                        : INF;

                    int right = (j + 1 < n)
                        ? grid[i][j + 1] + dp[k][i][j + 1]
                        : INF;

                    dp[k][i][j] = Math.min(down, right);

                    if (k > 0) {
                        int vid = comp.get(grid[i][j]);
                        dp[k][i][j] = Math.min(dp[k][i][j], best[vid]);
                    }
                }
            }
        }

        return dp[K][0][0] >= INF ? -1 : dp[K][0][0];
    }
}
