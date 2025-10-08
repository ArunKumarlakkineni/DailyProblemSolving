class Solution {
    public int bs(int[] potions,long success,int prod){
        int l = 0,r = potions.length-1;
        int res = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            long mul = prod*(long)potions[mid];
            if(mul>=success){
                res = Math.min(mid,res);
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int sp = bs(potions,success,spells[i]);
            // System.out.println(sp);
            res[i] = m - (sp==Integer.MAX_VALUE?m:sp);
        }
        return res;
    }
}