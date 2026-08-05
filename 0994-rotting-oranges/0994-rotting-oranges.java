class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshOranges = 0; // keep count of freshOranges so that everytime we turn them to rotten we how many are left at the end that didnt get affected and we can easily return -1

        //using multi source BFS so hat we can process the first batch of rotten oranges at minute 0 at a time
        Queue<int[]> queue = new ArrayDeque<>();

        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[]{row, col});// we add all rotten oranges so that they get process at the same minute
                }
                else if(grid[row][col] == 1){
                    freshOranges++; // will be easy for us to know if any orange didnt get affected we'll return -1
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

        while(!queue.isEmpty() && freshOranges > 0){

            int rottenOrangesInOneMinute = queue.size();
            for(int i=0; i<rottenOrangesInOneMinute; i++){
                int[] currentRottenOrange = queue.poll();

                for(int[] direction: directions){
                    int nextRow = currentRottenOrange[0] + direction[0];
                    int nextCol = currentRottenOrange[1] + direction[1];

                    if(nextRow<0 || nextRow>=grid.length || nextCol<0 || nextCol>=grid[0].length){
                        continue;
                    }

                    if(grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        freshOranges--;
                        queue.add(new int[]{nextRow, nextCol});
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