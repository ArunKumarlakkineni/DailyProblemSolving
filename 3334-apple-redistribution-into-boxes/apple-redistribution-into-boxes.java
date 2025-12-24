class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int tot = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int res = 0;
        int n = capacity.length;
        for(int i=n-1;i>=0;i--){
            if(tot<=0){
                break;
            }
            tot-=capacity[i];
            res++;
        }
        return res;
    }
}