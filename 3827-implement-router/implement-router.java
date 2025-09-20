record Packet(int source, int destination, int timestamp) {}

class Router {
    private int memoryLimit;
    private LinkedList<int[]> queue;
    private Set<String> seen;
    private Map<Integer, List<Integer>> destTimestamps;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.seen = new HashSet<>();
        this.destTimestamps = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;
        
        if (queue.size() >= memoryLimit) {
            int[] old = queue.poll();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            seen.remove(oldKey);
            
            // remove timestamp from destTimestamps
            List<Integer> list = destTimestamps.get(old[1]);
            list.remove(0); // always remove oldest timestamp
            if (list.isEmpty()) destTimestamps.remove(old[1]);
        }
        
        queue.add(new int[]{source, destination, timestamp});
        seen.add(key);
        
        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destTimestamps.get(destination).add(timestamp);
        
        return true;
    }
    
    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        
        int[] packet = queue.poll();
        String key = packet[0] + "#" + packet[1] + "#" + packet[2];
        seen.remove(key);
        
        // remove timestamp from destTimestamps
        List<Integer> list = destTimestamps.get(packet[1]);
        list.remove(0);
        if (list.isEmpty()) destTimestamps.remove(packet[1]);
        
        return packet;
    }
    
    // binary search to reduce time
    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;
        List<Integer> list = destTimestamps.get(destination);
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }
    
    // first index >= target
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = list.size(); // default: target bigger than all elements

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                ans = mid;        // mid might be answer
                right = mid - 1;  
            } else {
                left = mid + 1;  
            }
        }

        return ans;
    }

    // first index > target
    private int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = list.size(); 

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                ans = mid;       
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */