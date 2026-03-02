class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n];
        for(int i=0;i<n;i++){
            int c = 0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0){
                    c++;
                }else{
                    break;
                }
            }
            freq[i]=c;
        }
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;
            while (j < n && freq[j] < needed) j++;

            if (j == n) return -1;
            while (j > i) {
                int temp = freq[j];
                freq[j] = freq[j - 1];
                freq[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }
}