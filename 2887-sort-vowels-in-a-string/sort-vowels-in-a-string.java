class Solution {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);  // Makes it case-insensitive
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Check if character is a consonant (A-Z or a-z and not a vowel)
    public static boolean isConsonant(char ch) {
        ch = Character.toLowerCase(ch);  // Normalize case
        return Character.isLetter(ch) && !isVowel(ch);
    }
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        
        List<Character> li = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            if(isVowel(chars[i])){
                li.add(chars[i]);
            }
        }
        Collections.sort(li);
        StringBuilder sb = new StringBuilder(s);
        int k=0;
        for(int i=0;i<sb.length();i++){
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i,li.get(k));
                k++;
            }
        }
        return sb.toString();
        
    }
}