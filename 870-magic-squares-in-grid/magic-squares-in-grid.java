class Solution {
    private boolean isMagic(int[][] g, int r, int c) {
        // Center must be 5
        if (g[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        int sum = g[r][c] + g[r][c + 1] + g[r][c + 2];

        // Rows
        for (int i = 0; i < 3; i++) {
            if (g[r + i][c] + g[r + i][c + 1] + g[r + i][c + 2] != sum)
                return false;
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (g[r][c + j] + g[r + 1][c + j] + g[r + 2][c + j] != sum)
                return false;
        }

        // Diagonals
        if (g[r][c] + g[r + 1][c + 1] + g[r + 2][c + 2] != sum)
            return false;

        if (g[r][c + 2] + g[r + 1][c + 1] + g[r + 2][c] != sum)
            return false;

        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int count = 0;

        for (int i = 0; i <= r - 3; i++) {
            for (int j = 0; j <= c - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}