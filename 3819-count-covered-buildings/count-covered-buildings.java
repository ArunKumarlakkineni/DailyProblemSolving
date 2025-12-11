class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> mapX = new HashMap<>();
        Map<Integer, List<Integer>> mapY = new HashMap<>();

        for (int[] b : buildings) {
            mapX.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
            mapY.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[0]);
        }

        // Sort lists for binary search
        for (List<Integer> list : mapX.values()) Collections.sort(list);
        for (List<Integer> list : mapY.values()) Collections.sort(list);

        int res = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> ys = mapX.get(x);
            List<Integer> xs = mapY.get(y);

            // index of y in ys
            int yi = Collections.binarySearch(ys, y);
            int xi = Collections.binarySearch(xs, x);

            boolean hasBottom = yi > 0;
            boolean hasTop = yi < ys.size() - 1;
            boolean hasLeft = xi > 0;
            boolean hasRight = xi < xs.size() - 1;

            if (hasLeft && hasRight && hasTop && hasBottom)
                res++;
        }

        return res;
    }
}