class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int l=j+1,r=n-1;
                while(l<r){
                    long sum3 = (long)nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum3==target){
                        res.add(List.of(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                    }else if(sum3<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return new ArrayList(res);
    }
}