class Solution {
    int bs(int[] arr,int x){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] m:matrix){
            if(m[0]<=target && m[m.length-1]>=target){
                if(bs(m,target)!=-1)return true;
            }
        }
        return false;
    }
}