class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,
        boolean[] vis,boolean[] inRec,int u){
            vis[u] = true;
            inRec[u] = true;
            for(int v:adj.get(u)){
                if(!vis[v] && dfs(adj,vis,inRec,v)){
                    return true;
                }else if(inRec[v]){
                    return true;
                }
            }
            inRec[u] = false;
            return false;
        }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pr:prerequisites){
            adj.get(pr[1]).add(pr[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && dfs(adj,vis,inRec,i)){
                return false;
            }
        }
        return true;
    }
}