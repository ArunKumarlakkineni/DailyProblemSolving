class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;

        int H = hFences.length;
        int[] hf = new int[H + 2];
        hf[0] = 1;
        for (int i = 0; i < H; i++) hf[i + 1] = hFences[i];
        hf[H + 1] = m;

        int V = vFences.length;
        int[] vf = new int[V + 2];
        vf[0] = 1;
        for (int i = 0; i < V; i++) vf[i + 1] = vFences[i];
        vf[V + 1] = n;

        Arrays.sort(hf);
        Arrays.sort(vf);

        HashSet<Integer> heights = new HashSet<>();
        for (int i = 0; i < hf.length; i++) {
            for (int j = i + 1; j < hf.length; j++) {
                heights.add(hf[j] - hf[i]);
            }
        }

        long best = -1;
        for (int i = 0; i < vf.length; i++) {
            for (int j = i + 1; j < vf.length; j++) {
                int w = vf[j] - vf[i];
                if (heights.contains(w)) {
                    best = Math.max(best, 1L * w * w);
                }
            }
        }

        return best == -1 ? -1 : (int)(best % MOD);
    }
}