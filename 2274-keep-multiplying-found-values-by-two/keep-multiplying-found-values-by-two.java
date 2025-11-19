class Solution {
    public int findFinalValue(int[] nums, int original) {
        int org = original;
        int max = Arrays.stream(nums).max().getAsInt();
        int i = org;
        while(i<=max){
            boolean found = false;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i){
                    found =true;
                }
            }
            System.out.println(i+"--"+original);
            if(!found){
                return i;
            }
            i*=2;
        }
        return i;
    }
}