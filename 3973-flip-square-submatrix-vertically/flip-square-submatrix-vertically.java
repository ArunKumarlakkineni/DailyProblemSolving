class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int x1 = x+k;
        int y1 = y+k;
        int i = x;
        int i1 = x1-1;
        while(i<i1){
            for(int j=y;j<y1;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[i1][j];
                grid[i1][j] = temp;
            }
            i++;
            i1--;
        }
        return grid;
    }
}