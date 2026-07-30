class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n ; i++){
            if(visited[i] == false){
                count += 1;
                dfs(i, visited, adjList);
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int neighbor : adjList.get(node)){
            if(visited[neighbor] == false){
                dfs(neighbor, visited, adjList);
            }
        }
    }
}