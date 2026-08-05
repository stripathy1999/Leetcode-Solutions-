class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int row=0; row<rooms.length; row++){
            for(int col=0; col<rooms[0].length; col++){
                if(rooms[row][col] == 0){
                    queue.add(new int[]{row, col});
                }
            }
        }

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            int currentDistance = queue.size();
            for(int i=0; i<currentDistance; i++){
                int[] currentSpace = queue.poll();

                for(int[] direction : directions){
                    int nextRow = currentSpace[0] + direction[0];
                    int nextCol = currentSpace[1] + direction[1];

                    if(nextRow<0 || nextRow>=rooms.length || nextCol<0 || nextCol>=rooms[0].length){
                        continue;
                    }

                    if(rooms[nextRow][nextCol] == Integer.MAX_VALUE){
                        rooms[nextRow][nextCol] = rooms[currentSpace[0]][currentSpace[1]] + 1; 
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return;
    }
}