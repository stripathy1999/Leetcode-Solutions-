class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for(int[] interval: intervals){
            if((inserted == false) && interval[0] > newInterval[0]){
                result.add(newInterval);
                inserted = true;
            }
            result.add(interval);
        }
        if(inserted == false){
            result.add(newInterval);
        }

        return merge(result);
    }
    public int[][] merge(List<int[]> intervals){
        List<int[]> result = new ArrayList<>();
        int[] current = intervals.get(0);
        for(int i=1; i < intervals.size(); i++){
            int[] next = intervals.get(i);

            if(current[1] >= next[0]){
                current[1] = Math.max(current[1], next[1]);
            }
            else{
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
