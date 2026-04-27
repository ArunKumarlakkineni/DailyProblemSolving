class Solution {
    private record Direction(int di, int dj, List<Integer> reachable) {}
    private int n, m;
    private int[][] grid;
    private boolean[][] visited;
    private Map<Integer, List<Direction>> directions;
    private boolean dfs(int i, int j) {
        visited[i][j] = true;
        if (i == n - 1 && j == m - 1) return true;
        for (var dir : directions.get(grid[i][j])) {
            int nextI = i + dir.di();
            int nextJ = j + dir.dj();
            if (nextI >= 0 && nextI < n &&
                nextJ >= 0 && nextJ < m &&
                !visited[nextI][nextJ] &&
                dir.reachable().contains(grid[nextI][nextJ]) &&
                dfs(nextI, nextJ)) {
                return true;
            }
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        directions = Map.of(
            1, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(0, 1, List.of(1, 3, 5))),
            2, List.of(new Direction(-1, 0, List.of(2, 3, 4)), new Direction(1, 0, List.of(2, 5, 6))),
            3, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(1, 0, List.of(2, 5, 6))),
            4, List.of(new Direction(0, 1, List.of(1, 3, 5)), new Direction(1, 0, List.of(2, 5, 6))),
            5, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(-1, 0, List.of(2, 3, 4))),
            6, List.of(new Direction(0, 1, List.of(1, 3, 5)), new Direction(-1, 0, List.of(2, 3, 4)))
        );

        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        return dfs(0, 0);
    }
}