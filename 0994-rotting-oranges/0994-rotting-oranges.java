class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[]{row, col});
                }
                else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

        while(!queue.isEmpty() && freshOranges > 0){
            int rottenOrangesInThisMinute = queue.size();
            for(int i=0; i<rottenOrangesInThisMinute; i++){
                int[] currentOrange = queue.poll();

                for(int[] direction : directions){
                    int nextRow = currentOrange[0] + direction[0];
                    int nextCol = currentOrange[1] + direction[1];

                    if(nextRow<0 || nextRow >= grid.length || nextCol<0 || nextCol >= grid[0].length){
                        continue;
                    }

                    if(grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        queue.add(new int[]{nextRow, nextCol});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        if(freshOranges > 0){
            return -1;
        }

        return minutes;
    }
}