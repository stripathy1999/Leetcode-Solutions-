class Solution {
    class Pair{
        int node;
        int time;
        public Pair(int time, int node){
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        } 
        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int timeTaken = time[2];

            adjList.get(source).add(new Pair(timeTaken, target));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        minHeap.add(new Pair(0, k));

        int[] shortestTime = new int[n+1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        shortestTime[k] = 0;

        while(!minHeap.isEmpty()){
            Pair current = minHeap.poll();

            int currentTime = current.time;
            int currentNode = current.node;

            if(currentTime > shortestTime[currentNode]){
                continue;
            }

            for(Pair neighborNodeInfo : adjList.get(currentNode)){

                int neighborTime = neighborNodeInfo.time;
                int neighborNode = neighborNodeInfo.node;
                
                int newTime = currentTime + neighborTime;
                if(newTime < shortestTime[neighborNode] ){
                    shortestTime[neighborNode] = newTime; 
                    minHeap.add(new Pair(newTime, neighborNode));
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<=n; i++){
            if(shortestTime[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, shortestTime[i]);
        }

        return maxTime;
    }
}