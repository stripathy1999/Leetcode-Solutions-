class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] prevEnd = intervals[0];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            int[] current = intervals[i];
            if(prevEnd[1] > current[0]){
                count += 1;
                prevEnd[1] = Math.min(prevEnd[1], current[1]);
            }
            else{
                prevEnd[1] = current[1];
            }
        }
        return count;
    }
}