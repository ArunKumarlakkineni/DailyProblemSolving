class Solution {
    public String[] createGrid(int m, int n) {
        if(m==1){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(".");
            }
            return new String[]{sb.toString()};
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        String[] res = new String[m];
        res[0] = sb.toString();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==n-1) sb1.append(".");
            else sb1.append("#");
        }
        for(int i=1;i<m;i++){
            res[i] = sb1.toString();
        }
        return res;
    }
}