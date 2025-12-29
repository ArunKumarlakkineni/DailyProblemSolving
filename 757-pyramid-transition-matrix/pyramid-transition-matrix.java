class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean solve(String bottom, String temp, int idx) {
        // when one level is complete
        if (idx == bottom.length() - 1) {
            if (temp.length() == 1) return true;
            return solve(temp, "", 0);
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char ch : map.get(key)) {
            if (solve(bottom, temp + ch, idx + 1)) {
                return true;
            }
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return solve(bottom, "", 0);
    }
}