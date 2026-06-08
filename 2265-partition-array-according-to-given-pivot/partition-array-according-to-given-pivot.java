class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] less = new int[n],high = new int[n],res = new int[n];
        int count = 0,j=0,k=0;
        for(int num: nums){
            if(num<pivot)less[j++]=num;
            else if(num==pivot)count++;
            else high[k++] = num;
        }
        int in=0;
        for(int i=0;i<j;i++)res[in++]=less[i];
        for(int i=0;i<count;i++)res[in++] = pivot;
        for(int i=0;i<k;i++)res[in++]=high[i];
        return res;
    }
}