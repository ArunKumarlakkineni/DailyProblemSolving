class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int cn = 0;
            int psum=0;
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    if((nums[i]/j)==j){
                        psum+=j;
                        cn++;
                    }else{
                        psum+=(nums[i]/j);
                        psum+=j;
                        cn+=2;
                    }   
                }
            }
            if(cn==4){
                res+=psum;
            }
        }
        return res;
    }
}