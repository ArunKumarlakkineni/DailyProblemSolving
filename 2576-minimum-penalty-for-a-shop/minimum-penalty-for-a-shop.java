class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        // Step 1: total 'Y' (penalty if closed at hour 0)
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Step 2: sweep hours 1..n
        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);

            // If shop stays open for this hour
            if (c == 'Y') {
                penalty--; // one less 'Y' after closing
            } else {
                penalty++; // one more 'N' while open
            }

            // hour = i + 1
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}