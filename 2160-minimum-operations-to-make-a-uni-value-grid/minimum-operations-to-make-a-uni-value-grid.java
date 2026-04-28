class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] flattenedArray = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .toArray();
        int te = grid[0][0]%x,n=flattenedArray.length;
        int nn = Math.toIntExact(Arrays.stream(flattenedArray).filter(a -> a % x == te).count());
        if(nn!=n)return -1;
        Arrays.sort(flattenedArray);
        int mid = flattenedArray[n/2];
        int ops=0;
        for(int num:flattenedArray){
            ops+=(Math.abs(num-mid))/x;
        }
        return ops;
    }
}