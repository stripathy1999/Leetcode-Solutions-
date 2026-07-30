class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        //convert the matrix to an adjacencyList 
        for(int city = 0; city < isConnected.length; city++){
            adjList.add(new ArrayList<>());
        }

        for(int city1 = 0; city1 < isConnected.length; city1++){
            for(int city2 = 0; city2 < isConnected.length; city2++){
                if(isConnected[city1][city2] == 1){
                    adjList.get(city1).add(city2);
                    adjList.get(city2).add(city1);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int city = 0; city < isConnected.length; city++){
            if(visited[city] == false){
                count += 1;
                dfs(city, visited, adjList);
            }
        }
        return count;
    }

    public void dfs(int city, boolean[] visited, List<List<Integer>> adjList){
        visited[city] = true;
        for(int neighbor : adjList.get(city)){
            if(visited[neighbor] == false){
                dfs(neighbor, visited, adjList);
            }
        }
    }
}