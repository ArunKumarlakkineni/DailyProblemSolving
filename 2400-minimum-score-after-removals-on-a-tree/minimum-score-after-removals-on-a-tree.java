class Solution {
    int[] inTime, outTime, xorSubtree, parent;
    int time = 0;
    List<Integer>[] tree;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        inTime = new int[n];
        outTime = new int[n];
        xorSubtree = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        // Build tree as adjacency list
        tree = new ArrayList[n];
        for (int i = 0; i < n; ++i) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        // DFS to fill inTime, outTime, xorSubtree
        dfs(0, -1, nums);

        int totalXOR = xorSubtree[0];

        // Build edgeChildren list using parent[]
        List<Integer> edgeChildren = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == u) {
                edgeChildren.add(v);
            } else {
                edgeChildren.add(u);
            }
        }

        int minScore = Integer.MAX_VALUE;
        int m = edgeChildren.size();

        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int u = edgeChildren.get(i);
                int v = edgeChildren.get(j);

                int a, b, c;

                if (isAncestor(u, v)) {
                    a = xorSubtree[v];
                    b = xorSubtree[u] ^ xorSubtree[v];
                    c = totalXOR ^ xorSubtree[u];
                } else if (isAncestor(v, u)) {
                    a = xorSubtree[u];
                    b = xorSubtree[v] ^ xorSubtree[u];
                    c = totalXOR ^ xorSubtree[v];
                } else {
                    a = xorSubtree[u];
                    b = xorSubtree[v];
                    c = totalXOR ^ a ^ b;
                }

                int maxXOR = Math.max(a, Math.max(b, c));
                int minXOR = Math.min(a, Math.min(b, c));
                minScore = Math.min(minScore, maxXOR - minXOR);
            }
        }

        return minScore;
    }
    private void dfs(int u, int p, int[] nums) {
        inTime[u] = time++;
        xorSubtree[u] = nums[u];
        for (int v : tree[u]) {
            if (v == p) continue;
            parent[v] = u;
            dfs(v, u, nums);
            xorSubtree[u] ^= xorSubtree[v];
        }
        outTime[u] = time++;
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}