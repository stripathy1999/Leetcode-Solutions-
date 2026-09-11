class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        for(char ch : tasks){
            freqMap[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int count : freqMap){
            if(count>0){
                maxHeap.add(count);
            }
        }
        
        Queue<int[]> coolDown = new ArrayDeque<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !coolDown.isEmpty()){

            time++;
            if(!maxHeap.isEmpty()){
                int topCount = maxHeap.poll();
                topCount--;

                if(topCount>0){
                    coolDown.add(new int[]{topCount, time + n + 1});
                }
            }

            if(!coolDown.isEmpty() && coolDown.peek()[1] == time+1){
                int[] topCountInfo = coolDown.poll();
                int remainingCount = topCountInfo[0];

                maxHeap.add(remainingCount);
            }                                                
        }
        return time;
    }
}