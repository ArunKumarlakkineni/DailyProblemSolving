class Solution {
    List<List<Integer>> st = new ArrayList<>();
    public void solve(int[] candidates,int si,int target,List<Integer> sub){
        if (target == 0) {
            st.add(new ArrayList<>(sub));
            return;
        }

        for (int i = si; i < candidates.length; i++) {
            if (i > si && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;
            sub.add(candidates[i]);
            solve(candidates ,i+1 ,target-candidates[i], sub);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates,0,target,new ArrayList<>());
        return st;
    }
}