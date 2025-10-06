class Solution {
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], i = cur[1], j = cur[2];
            res = Math.max(res, h);
            if (i == n - 1 && j == n - 1) return res;
            if (vis[i][j]) continue;
            vis[i][j] = true;

            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y]) {
                    pq.offer(new int[]{grid[x][y], x, y});
                }
            }
        }
        return res;
    }
}