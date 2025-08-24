class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int n1 = nums1.length,n2 = nums2.length;
        int[] merged = new int[n1+n2];
        int resSize = n1+n2;
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                merged[k++] = nums1[i++];
            }else {
                merged[k++] = nums2[j++];
            }
        }
        while(i<n1){
            merged[k++] = nums1[i++];
        }
        while(j<n2){
            merged[k++] = nums2[j++];
        }
        if(merged.length%2==0){
            res = ((double)merged[resSize/2]+(double)merged[(resSize-1)/2])/2.0;
        }else{
            res = merged[resSize/2];
        }
        return res;
    }
}