class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] bms = new int[n];
        for(int i=0;i<n;i++){
            bms[i] = (int)bank[i].chars().filter(ch -> ch == '1').count();
        }
        int res = 0,curr = bms[0];
        for(int i=1;i<n;i++){
            if(curr==0){
                curr = bms[i];
                continue;
            }
            if(bms[i]!=0){
                res += curr*bms[i];
                curr = bms[i];
            }
        }
        return res;
    }
}