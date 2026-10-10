class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] dif = new int[100000+1];
        int n = nums1.length;
        for(int i=0;i<n;i++){
            int d = Math.abs(nums1[i]-nums2[i]);
            dif[d]++;
        }

        int k = k1+k2;
        for(int d = 100000;d>0 && k>0;d--){
            int minOps = Math.min(dif[d],k);
            dif[d] -= minOps;
            dif[d-1] += minOps;
            k -= minOps;
        }

        long res = 0;
        for(int i=1;i<=100000;i++){
            res += (long)dif[i]*i*i;
        }
        return res;
    }
}