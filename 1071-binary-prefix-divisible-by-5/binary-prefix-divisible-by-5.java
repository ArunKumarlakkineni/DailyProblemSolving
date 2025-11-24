class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int mod = 0;
        List<Boolean> li = new ArrayList<>();

        for (int bit : nums) {
            mod = (mod * 2 + bit) % 5;
            li.add(mod == 0);
        }

        return li;
    }
}