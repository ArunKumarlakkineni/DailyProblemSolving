class Solution {
    int n;
    long[][] dp;
    public long solve(int i,int trend,int[] nums){
        if(i==n){
            if(trend==3){
                return 0;
            }else{
                return Long.MIN_VALUE/2;
            }
        }
        if(dp[i][trend]!=Long.MAX_VALUE){
            return dp[i][trend];
        }
        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;
        if(trend == 0){
            skip = solve(i+1,trend,nums);
        }
        if(trend == 3){
            skip = nums[i];
        }

        if(i+1<n){
            int cur = nums[i];
            int next = nums[i+1];
            if(trend==0){
                if(cur<next){
                    take = Math.max(take,cur+solve(i+1,1,nums));
                }
            }else if(trend==1){
                if(cur<next){
                    take = Math.max(take,cur+solve(i+1,trend,nums));
                }else if(cur>next){
                    take = Math.max(take,cur+solve(i+1,2,nums));
                }
            }else if(trend==2){
                if(cur>next){
                    take = Math.max(take,cur+solve(i+1,trend,nums));
                }else if(cur<next){
                    take = Math.max(take,cur+solve(i+1,3,nums));
                }
            }else if(trend==3 && cur<next){
                take = Math.max(take,cur+solve(i+1,3,nums));
            }
        }

        return dp[i][trend] = Math.max(take,skip);
    }
    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        dp = new long[n+1][4];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],Long.MAX_VALUE);
        }
        return solve(0,0,nums);
    }
}