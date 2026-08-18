class Solution {
    public int numEnclaves(int[][] grid) {
        //traverse the both ends of the row borders
        for(int col = 0; col<grid[0].length; col++){
            dfs(0, col, grid);
            dfs(grid.length-1, col, grid);
        }
        //traverse both ends of column borders
        for(int row = 0; row<grid.length; row++){
            dfs(row, 0, grid);
            dfs(row, grid[0].length-1, grid);
        }

        int enclaves = 0;
        for(int row = 0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == 1){
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
    public void dfs(int row, int col, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;
        
        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);
    }
}