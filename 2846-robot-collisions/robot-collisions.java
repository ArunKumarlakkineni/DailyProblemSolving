class Robot {
    int pos;
    char dir;
    int health;
    int orig_i;

    Robot(int pos, char dir, int health, int orig_i) {
        this.pos = pos;
        this.dir = dir;
        this.health = health;
        this.orig_i = orig_i;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(
                positions[i],
                directions.charAt(i),
                healths[i],
                i
            );
        }
        Arrays.sort(robots, (a, b) -> Integer.compare(a.pos, b.pos));
        Stack<Robot> stack = new Stack<>();
        for(Robot cur:robots){
            while(!stack.empty() && stack.peek().dir=='R' && cur.dir=='L'){
                Robot top = stack.peek();
                if(top.health>cur.health){
                    top.health -= 1;
                    cur.health = 0;
                    break;
                }else if(top.health <cur.health){
                    stack.pop();
                    cur.health -= 1;
                }else{
                    stack.pop();
                    cur.health = 0;
                    break;
                }
            }
            if(cur.health>0){
                stack.push(cur);
            }
        }
        stack.sort((a,b) -> Integer.compare(a.orig_i,b.orig_i));
        List<Integer> res = new ArrayList<>();
        for(Robot r:stack){
            res.add(r.health);
        }
        return res;
    }
}