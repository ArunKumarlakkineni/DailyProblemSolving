class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] nums = Arrays.stream(arr)
                            .boxed()
                            .toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            if (Integer.bitCount(a) != Integer.bitCount(b)) {
                return Integer.bitCount(a) - Integer.bitCount(b);
            }
            return a - b;
        });

        return Arrays.stream(nums)
                        .mapToInt(Integer::intValue)
                        .toArray();
    }
}