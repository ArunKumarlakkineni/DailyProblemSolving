class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        if (n == 0 || m == 0) return 0L;

        long[] pref = new long[n];
        pref[0] = skill[0];
        for (int i = 1; i < n; ++i) pref[i] = pref[i-1] + (long) skill[i];

        if (m == 1) return pref[n-1] * (long) mana[0];

        long S = 0L;
        for (int j = 1; j < m; ++j) {
            long delta = pref[0] * (long) mana[j-1]; // i = 0 term
            for (int i = 1; i < n; ++i) {
                long cand = pref[i] * (long) mana[j-1] - pref[i-1] * (long) mana[j];
                if (cand > delta) delta = cand;
            }
            S += delta;
        }

        return S + pref[n-1] * (long) mana[m-1];
    }
}