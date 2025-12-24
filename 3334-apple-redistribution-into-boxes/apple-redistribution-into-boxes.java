class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int tot = Arrays.stream(apple).sum();
        capacity = Arrays.stream(capacity)
                 .boxed()
                 .sorted(Collections.reverseOrder())
                 .mapToInt(Integer::intValue)
                 .toArray();
        int res = 0;
        for(int i=0;i<capacity.length;i++){
            if(tot<=0){
                break;
            }
            tot-=capacity[i];
            res++;
        }
        return res;
    }
}