class Solution {
    public boolean isBipartite(int[][] graph) {
        char[] color = new char[graph.length];
        for(int i=0; i<graph.length; i++){
            if(color[i] == '\0'){
                if(dfs(i, 'Y', graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, char currentColor, int[][] graph, char[] color){
        color[node] = currentColor;

        for(int neighbor : graph[node]){
            if(color[neighbor] == '\0'){

                char nextColor;
                if(color[node] == 'Y'){
                    nextColor = 'G';
                }
                else{
                    nextColor = 'Y';
                }
                
                if(dfs(neighbor, nextColor, graph, color) == false){
                    return false;
                }
            }
            else if(color[node] == color[neighbor]){
                return false;
            } 
        }
        return true;
    }
}