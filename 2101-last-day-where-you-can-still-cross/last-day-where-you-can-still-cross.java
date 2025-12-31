class Solution {
    public boolean solve(int[][] grid, int row, int col, boolean[][] vis) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return false;
        if (grid[row][col] == 1 || vis[row][col])
            return false;

        if (row == 0) return true;

        vis[row][col] = true;

        return solve(grid, row - 1, col, vis) ||
               solve(grid, row, col - 1, vis) ||
               solve(grid, row, col + 1, vis) ||
               solve(grid, row + 1, col, vis);
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int[][] grid = new int[row][col];
            for (int i = 0; i < mid; i++) {
                int[] cell = cells[i];
                grid[cell[0] - 1][cell[1] - 1] = 1;
            }

            boolean canCross = false;
            for (int c = 0; c < col; c++) {
                if (grid[row - 1][c] == 0) {
                    boolean[][] vis = new boolean[row][col];
                    if (solve(grid, row - 1, c, vis)) {
                        canCross = true;
                        break;
                    }
                }
            }

            if (canCross) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}