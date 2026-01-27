class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],2*edge[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int weight = cur[1];
            if(u==n-1) return weight;
            for(int[] neigh:adj.get(u)){
                int v = neigh[0];
                int newWeight = weight+neigh[1];
                if(dist[v] > newWeight){
                    dist[v] = newWeight;
                    pq.add(new int[]{v,newWeight});
                }
            }
        }
        return -1;
    }
}