class Solution {
    int[] getNSR(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] NSR = new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                NSR[i] = n;
            }else{
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    NSR[i] = n;
                }else{
                    NSR[i] = st.peek();
                }
            }
            st.push(i);
        }
        return NSR;
    }
    int[] getNSL(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] NSL = new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                NSL[i] = -1;
            }else{
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    NSL[i] = -1;
                }else{
                    NSL[i] = st.peek();
                }
            }
            st.push(i);
        }
        return NSL;
    }
    int findMaxArea(int[] heights){
        //find width
        int[] NSR = getNSR(heights);
        int[] NSL = getNSL(heights);
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea,(NSR[i]-NSL[i]-1)*heights[i]);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[cols];
        for(int i=0;i<cols;i++){
            heights[i] = matrix[0][i]=='1'?1:0;
        }
        maxArea = findMaxArea(heights);
        for(int row=1;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(matrix[row][col]=='0'){
                    heights[col]=0;
                }else{
                    heights[col]+=1;
                }
            }
            maxArea = Math.max(maxArea,findMaxArea(heights));
        }
        return maxArea;
    }
}