class Solution {
    
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> vis = new HashSet<>();
        String smallest = s;
        Deque<String> dq = new ArrayDeque<>();
        dq.offer(s);
        vis.add(s);
        while(!dq.isEmpty()){
            String cur = dq.poll();
            if(cur.compareTo(smallest)<0)smallest = cur;
            StringBuilder sb = new StringBuilder(cur);
            for(int i=1;i<sb.length();i+=2){
                sb.setCharAt(i,(char)((sb.charAt(i)-'0' + a)%10 + '0'));
            }
            String added = sb.toString();
            if(vis.add(added)) dq.offer(added);
            String rotated = cur.substring(cur.length()-b) 
                + cur.substring(0,cur.length()-b);
            if(vis.add(rotated)) dq.offer(rotated);
        }
        return smallest;
    }
}