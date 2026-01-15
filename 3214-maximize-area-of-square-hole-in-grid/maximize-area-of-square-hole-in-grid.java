class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h = 0;
        int hmax = 0;
        
        for(int i=1;i<hBars.length;i++){
            if(hBars[i-1]+1==hBars[i]){
                h++;
            }else{
                hmax = Math.max(hmax,h);
                h=0;
            }
        }
        
        
        int v = 0;
        int vmax = 0;
        
        for(int i=1;i<vBars.length;i++){
            if(vBars[i-1]+1==vBars[i]){
                v++;
            }else{
                vmax = Math.max(vmax,v);
                v=0;
            }
        }
        vmax = Math.max(vmax,v);
        hmax = Math.max(hmax,h);
        
        int side = Math.min(vmax+2,hmax+2);
        return side*side;
    }
}