class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(mat[row][col] == 0){
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            int[] currentCell = queue.poll();

            int currentRow = currentCell[0];
            int currentCol = currentCell[1];

            for(int[] direction : directions){
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow < 0 || newRow >= rows || newCol<0 || newCol >= cols){
                    continue;
                }

                if(visited[newRow][newCol] == true){
                    continue;
                }

                distance[newRow][newCol] = distance[currentRow][currentCol] + 1;
                visited[newRow][newCol] = true;
                queue.add(new int[]{newRow, newCol});
            }
        }
        return distance;
    }
}