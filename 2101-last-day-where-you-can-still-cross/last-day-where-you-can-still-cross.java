class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                vis[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == row - 1) return true;

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}