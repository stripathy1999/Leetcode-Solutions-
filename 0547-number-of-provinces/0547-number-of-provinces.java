class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0; //to count how many times we called the traversal on a node. This would traverse on the first node of the connected components

        // convert the matrix into an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        int[] visited = new int[isConnected.length];
        for(int row = 0; row < isConnected.length; row++){
            if(visited[row] == 0){
                count++;
                dfs(row, visited, isConnected);

            }
        }
        return count;
    }

    public static void dfs(int node, int[] visited, int[][] isConnected){
        visited[node] = 1;
        for(int row = 0; row < isConnected.length; row++){
            if(visited[row] == 0 && isConnected[node][row] == 1){
                dfs(row, visited, isConnected);
            }
        }
    }
}