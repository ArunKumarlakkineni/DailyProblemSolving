class Solution {
    List<List<Integer>> st = new ArrayList<>();
    public void solve(int[] candidates,int si,int target,List<Integer> sub){
        if(target==0){
            st.add(new ArrayList<>(sub));
            return;
        }
        if(si>=candidates.length||target<0) return;
        // Include current element
        sub.add(candidates[si]);
        solve(candidates, si + 1, target - candidates[si], sub);
        sub.remove(sub.size() - 1);

        // Skip all duplicates of current element (important!)
        int nextIndex = si + 1;
        while (nextIndex < candidates.length && candidates[nextIndex] == candidates[si]) {
            nextIndex++;
        }

        // Exclude current and move to next different value
        solve(candidates, nextIndex, target, sub);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates,0,target,new ArrayList<>());
        return st;
    }
}