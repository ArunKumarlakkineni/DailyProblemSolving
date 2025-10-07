class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); // default value for dry days
        Map<Integer, Integer> lastRainDay = new HashMap<>(); // lake -> last rain day
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of dry days

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i); // possible day to dry a lake
            } else {
                // lake is already full, need to find a dry day to empty it
                if (lastRainDay.containsKey(lake)) {
                    int lastDay = lastRainDay.get(lake);
                    // find the earliest dry day after lastDay
                    Integer dryDay = dryDays.ceiling(lastDay);
                    if (dryDay == null) {
                        return new int[]{}; // no available dry day → flood
                    }
                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                lastRainDay.put(lake, i);
                ans[i] = -1; // it rained today
            }
        }
        return ans;

    }
}