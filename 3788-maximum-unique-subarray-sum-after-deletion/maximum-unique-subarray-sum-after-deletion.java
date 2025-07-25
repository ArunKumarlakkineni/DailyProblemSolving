class Solution {
    public void reverse(int[] nums){
        int l = 0, r = nums.length-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public int maxSum(int[] nums) {
        
        int curr = 0;
        int res = 0;
        int n = nums.length;
        Set<Integer> st = new LinkedHashSet<>();
        for(int num:nums){
            st.add(num);
        }
        int resArray[] = st.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(resArray);
        reverse(resArray);
        if(resArray[0]<0)return resArray[0];
        curr = resArray[0];
        res = resArray[0];
        for(int i=1;i<resArray.length;i++){
            if(resArray[i]!=resArray[i-1]){
                curr+=resArray[i];
            }else{
                curr = 0;
            }
            res = Math.max(res,curr);
        }
        return res;
    }
}