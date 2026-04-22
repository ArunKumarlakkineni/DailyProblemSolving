class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        for(String q : queries){
            for(String dic:dictionary){
                int dif = 0;
                for(int i=0;i<q.length();i++){
                    if(q.charAt(i)!=dic.charAt(i)){
                        dif++;
                    }
                    if(dif>2) break;
                }
                if(dif<=2){
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}