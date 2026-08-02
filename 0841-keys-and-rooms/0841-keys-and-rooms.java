class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        dfs(0, visited, rooms);

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
    public void dfs(int room, boolean[] visited, List<List<Integer>> rooms){
        visited[room] = true;
        for(int nextRoom : rooms.get(room)){
            if(visited[nextRoom] == false){
                dfs(nextRoom, visited, rooms);
            }
        }
    }
}