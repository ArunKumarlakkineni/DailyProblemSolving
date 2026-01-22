class Solution {
    // Map<Integer,Integer> parent;
    // Map<Integer, Integer> rank;
    // public void union(int x,int y){
    //     int xp = find(x,parent);
    //     int yp = find(y,parent);
    //     if(xp==yp) return;
    //     else if(ranks[xp]>rank[yp]){
    //         // parent[yp] = xp;
    //         mp.put(yp,xp);
    //     }else if(rank[xp]<rank[yp]){
    //         // parent[xp] = yp;
    //         mp.put(xp,yp);
    //     }else{
    //         mp.put(yp,xp);
    //         rank[xp]++;
    //     }
    // }
    // public int find(int x,Map<Integer,Integer> parent){
    //     if(x==parent.get(x)) return x;
    //     parent.put(x, find(parent.get(x), parent));
    //     return parent.get(x);
    // }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        // Add all numbers to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // Check if this is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}