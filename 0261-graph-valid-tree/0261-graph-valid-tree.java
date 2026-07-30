class Solution {
    public boolean validTree(int n, int[][] edges) {
        //A valid tree wull have n-1 edges. 
        if(edges.length != n-1){
            return false;
        }

        //create adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ;i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //need to check if the nodes are all connected in a graph
        boolean[] visited = new boolean[n];
        dfs(0, visited, adjList);

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }
    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList)
    {
        visited[node]= true;
        for(int neighbor : adjList.get(node)){
            if(visited[neighbor] == false){
                dfs(neighbor, visited, adjList);
            }
        }
    }
}