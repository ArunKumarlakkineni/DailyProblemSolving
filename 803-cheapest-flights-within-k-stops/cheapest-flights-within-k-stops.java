class State {
        int node, cost, stops;
        State(int n, int c, int s) {
            node = n;
            cost = c;
            stops = s;
        }
    }

class Solution {
    public void buildGraph(ArrayList<ArrayList<int[]>> adj,int[][] flights){
        for(int[] f:flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        buildGraph(adj,flights);
        int[][] dist = new int[n][k+2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new State(src, 0, 0));
        dist[src][0] = 0;
        while(!pq.isEmpty()){
            State curr = pq.poll();
            int u = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;
            if(u==dst) return cost;
            if(stops>k) continue;
            for(int[] neigh:adj.get(u)){
                int v = neigh[0];
                int price = neigh[1];
                int newCost = cost+price;
                if(newCost < dist[v][stops+1]){
                    dist[v][stops+1] = newCost;
                    pq.add(new State(v,newCost,stops+1));
                }
            } 
        }
        return -1;
    }
}