class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, PriorityQueue<Integer>> dmp = new HashMap<>();
        int rows = grid.length, cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int key = i-j;
                dmp.putIfAbsent(key,key<0 ?new PriorityQueue<>():
                    new PriorityQueue<>(Collections.reverseOrder()));
                dmp.get(key).offer(grid[i][j]);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int key = i-j;
                grid[i][j] = dmp.get(key).poll();
            }
        }
        return grid;
    }
}