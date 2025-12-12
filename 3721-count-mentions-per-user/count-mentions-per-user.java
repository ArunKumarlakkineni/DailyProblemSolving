class Solution {
    private static int getRank(String type) {
        switch (type) {
            case "MESSAGE": return 2;
            case "OFFLINE": return 1;
            default: return 3; // anything else goes last
        }
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] res = new int[numberOfUsers];
        Map<Integer,Integer> mp = new HashMap<>();
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));

            // Sort by time
            int cmp = Integer.compare(timeA, timeB);
            if (cmp != 0) return cmp;

            // Same time → sort by type priority
            return Integer.compare(getRank(a.get(0)), getRank(b.get(0)));
        });
        for(int in=0;in<events.size();in++){
            int ts = Integer.parseInt(events.get(in).get(1));
            if(events.get(in).get(0).equals("MESSAGE")){
                String[] ids = events.get(in).get(2).split(" ");
                
                if(ids[0].equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++){
                        res[i]++;
                    }
                }else if(ids[0].equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(mp.containsKey(i)){
                            int tso = mp.get(i);
                            if(tso<=ts){
                                res[i]++;
                            }
                        }else{
                            res[i]++;
                        }
                    }
                }
                else{
                    for(int i=0;i<ids.length;i++){
                        int id = Integer.parseInt(ids[i].substring(2,ids[i].length()));
                        res[id]++;
                    }
                }
            }else{
                int ido = Integer.parseInt(events.get(in).get(2));
                mp.put(ido,Integer.parseInt(events.get(in).get(1))+60);
            }
        }
        return res;
    }
}