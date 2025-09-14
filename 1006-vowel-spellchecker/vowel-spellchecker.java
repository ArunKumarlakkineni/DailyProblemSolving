class Solution {
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> lowerCaseMap = new HashMap<>();
        Map<String, String> vowelMaskMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            lowerCaseMap.putIfAbsent(lower, word);

            String vowelMasked = maskVowels(lower);
            vowelMaskMap.putIfAbsent(vowelMasked, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (lowerCaseMap.containsKey(lower)) {
                    result[i] = lowerCaseMap.get(lower);
                } else {
                    String vowelMasked = maskVowels(lower);
                    result[i] = vowelMaskMap.getOrDefault(vowelMasked, "");
                }
            }
        }

        return result;
    }
}