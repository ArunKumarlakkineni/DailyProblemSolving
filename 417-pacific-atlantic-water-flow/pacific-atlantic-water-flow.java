class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }
        visited[i][j] = true;
        for (int[] d : dirs) {
            dfs(heights, visited, i + d[0], j + d[1], heights[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from Pacific and Atlantic edges
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}