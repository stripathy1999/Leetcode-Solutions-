class Solution {
    public int maximumDetonation(int[][] bombs) {
        int maximumBombs = 0;

        //creat adjacency list of bombs that will explode from single bomb
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<bombs.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<bombs.length; i++){
            for(int j=0; j<bombs.length; j++){
                long x1 = bombs[i][0];
                long x2 = bombs[j][0];

                long y1 = bombs[i][1];
                long y2 = bombs[j][1];

                long radius = bombs[i][2];

                long distance = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);
                if(distance <= radius * radius){
                    adjList.get(i).add(j);
                }
            }
        }

        
        for(int i=0; i<bombs.length; i++){
            int detonatedBombs = 0;
            boolean[] visited = new boolean[bombs.length];
            detonatedBombs = dfs(i, detonatedBombs, visited, adjList);
            maximumBombs = Math.max(detonatedBombs, maximumBombs);
        }
        return maximumBombs;
    }
    public int dfs(int bomb, int detonatedBombs, boolean[] visited, List<List<Integer>> adjList){
        visited[bomb] = true;
        detonatedBombs = 1;

        for(int nextBomb : adjList.get(bomb)){
            if(visited[nextBomb] == true){
                continue;
            }

            detonatedBombs += dfs(nextBomb, detonatedBombs, visited, adjList);
        }
        return detonatedBombs;
    }
}