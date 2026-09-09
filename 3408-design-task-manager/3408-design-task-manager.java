class TaskManager {

    Map<Integer, int[]> map;
    TreeSet<int[]> taskOrder;
     
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        taskOrder = new TreeSet<>((a,b) -> {
            if(a[0] != b[0]){
                return b[0] - a[0];
            }
            else{
                return b[1] - a[1];
            }
        });

        for(List<Integer> task : tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            map.put(taskId, new int[]{priority, userId});
            taskOrder.add(new int[]{priority, taskId});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{priority, userId});
        taskOrder.add(new int[]{priority, taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        int[] info = map.get(taskId);
        int oldPriority = info[0];
        int userId = info[1];

        taskOrder.remove(new int[]{oldPriority, taskId});
        map.put(taskId, new int[]{newPriority, userId});
        taskOrder.add(new int[]{newPriority, taskId});
    }
    
    public void rmv(int taskId) {
        int[] info = map.get(taskId);
        int priority = info[0];

        map.remove(taskId);
        taskOrder.remove(new int[]{priority, taskId});
    }
    
    public int execTop() {
        if(taskOrder.isEmpty()){
            return -1;
        }

        int[] taskInfo = taskOrder.first();
        int taskId = taskInfo[1];
        int priority = taskInfo[0];
        int userId = map.get(taskId)[1];

        map.remove(taskId);
        taskOrder.remove(new int[]{priority, taskId});

        return userId;
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