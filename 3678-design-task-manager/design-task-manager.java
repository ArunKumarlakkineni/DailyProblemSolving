class Task{
    int userId;
    int taskId;
    int priority;
    Task(int uid,int tid,int pr){
        userId = uid;
        taskId = tid;
        priority = pr;
    }
}
class TaskManager {
    TreeSet<Task> ts = new TreeSet<>((a, b) -> {
        if (a.priority != b.priority) {
            return b.priority - a.priority; // Higher priority comes first
        }
        return b.taskId - a.taskId; // If same priority, higher taskId comes first
    });
    Map<Integer,Task> mp = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for(int i=0;i<tasks.size();i++){
            Task task = new Task(tasks.get(i).get(0),tasks.get(i).get(1),tasks.get(i).get(2));
            ts.add(task);
            mp.put(task.taskId,task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId,taskId,priority);
        ts.add(task);
        mp.put(taskId,task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task t = mp.get(taskId);
        if (t != null) {
            ts.remove(t);
            t.priority = newPriority; 
            ts.add(t);             
        }
    }
    
    public void rmv(int taskId) {
        Task t = mp.get(taskId);
        ts.remove(t);
    }
    
    public int execTop() {
        if(ts.size()==0)return -1;
        return ts.pollFirst().userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */