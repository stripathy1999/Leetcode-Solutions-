class Solution {
    class Pair{
        int cost;
        int node;
        public Pair(int cost, int node){
            this.cost = cost;
            this.node = node;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> adjList = new ArrayList<>();

        for(int i=0; i<points.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adjList.get(i).add(new Pair(cost, j));
                adjList.get(j).add(new Pair(cost, i));
            }
        }

        boolean[] visited = new boolean[points.length];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));

        minHeap.add(new Pair(0,0));
        
        int totalCost = 0;
        int pointsConnected = 0;

        while(!minHeap.isEmpty() && pointsConnected < points.length){
            Pair current = minHeap.poll();

            int currentCost = current.cost;
            int currentNode = current.node;

            if(visited[currentNode] == true){
                continue;
            }

            visited[currentNode] = true;
            pointsConnected++;
            totalCost += currentCost;

            for(Pair neighbors : adjList.get(currentNode)){
                int neighborNode = neighbors.node;
                int neighborCost = neighbors.cost;

                if(visited[neighborNode] == false){
                    minHeap.add(new Pair(neighborCost, neighborNode));
                }
            }
        }
        return totalCost;
    }
}