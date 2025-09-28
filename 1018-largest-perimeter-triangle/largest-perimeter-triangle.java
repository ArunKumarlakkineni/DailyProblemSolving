class Solution {
    public boolean triangle(int x,int y,int z){
        return ((x+y)>z&&(z+y)>x&&(x+z)>y);
    }
    public int largestPerimeter(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int i = n-3,j=n-2,k=n-1;
        while(i>=0){
            int a = nums[i], b= nums[j], c = nums[k];
            if(triangle(a,b,c)){
                return a+b+c;
            }else{
                i--;
                j--;
                k--;
            }
        }
        return 0;
    }
}