class Solution {
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,
        int u,Stack<Integer> st,boolean[] vis,boolean[] inRec){
        vis[u] = true;
        inRec[u] = true;
        for(int v:adj.get(u)){
            if(!vis[v] && dfs(adj,v,st,vis,inRec)){
                return true;
            }else if(inRec[v]){
                return true;
            }
        }
        inRec[u] = false;
        st.push(u);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pr:prerequisites){
            adj.get(pr[1]).add(pr[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && dfs(adj,i,st,vis,inRec)){
                return new int[]{};
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.pop();
        }
        return res;
    }
}