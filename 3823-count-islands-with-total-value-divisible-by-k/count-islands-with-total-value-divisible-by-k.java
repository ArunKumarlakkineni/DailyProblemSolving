class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        int[][] dx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    Queue<int[]> q = new LinkedList<>();

                    q.add(new int[]{i, j});
                    sum += grid[i][j];
                    grid[i][j] = -1; // Mark visited immediately

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] d : dx) {
                            int nx = cur[0] + d[0];
                            int ny = cur[1] + d[1];

                            if (nx >= 0 && nx < m &&
                                ny >= 0 && ny < n &&
                                grid[nx][ny] > 0) {

                                sum += grid[nx][ny];
                                q.add(new int[]{nx, ny});
                                grid[nx][ny] = -1; // Mark when enqueued
                            }
                        }
                    }

                    if (sum % k == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}