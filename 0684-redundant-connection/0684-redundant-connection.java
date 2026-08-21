class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
       
        for(int i = 0; i<=edges.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            boolean[] visited = new boolean[edges.length+1];

            if(dfs(u, v, visited, adjList) == false){
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            else{
                return new int[]{u, v};
            }
        }
        return new int[0];
    }
    public boolean dfs(int u, int v, boolean[] visited, List<List<Integer>> adjList){
        if(u == v){
            return true;
        }

        visited[u] = true;
        for(int next : adjList.get(u)){
            if(visited[next] == false){
                if(dfs(next, v, visited, adjList) == true){
                    return true;
                }
            }
        }
        return false;
    }
}