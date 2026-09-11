class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 0;

        for(int task: tasks){

            day++;
            
            if(map.containsKey(task)){
                long nextAvailableDay = map.get(task);
                
                if(day < nextAvailableDay){
                    day = nextAvailableDay;
                }
            }
            map.put(task, space + day + 1);
        }
        return day;   
    }
}