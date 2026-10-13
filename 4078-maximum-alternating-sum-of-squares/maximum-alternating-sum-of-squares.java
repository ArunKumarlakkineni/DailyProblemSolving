class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] temp = Arrays.stream(nums)
        .boxed()
        .toArray(Integer[]::new);
        Arrays.sort(temp, (a, b) -> Integer.compare(
            Math.abs(a), Math.abs(b)
        ));
        long res = 0;
        int n = nums.length;
        int st = 0,en = n-1;
        while(st<en){
            res += (temp[en]*temp[en]) -(temp[st]*temp[st]);
            st++;
            en--;
        }
        if(st==en) res+= (temp[en]*temp[en]);

        return res;
    }
}