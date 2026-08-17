class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> islandSet = new HashSet<>();
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] == 1){
                    StringBuilder shape = new StringBuilder();
                    dfs(row, col, row, col, shape, grid);
                    islandSet.add(shape.toString());
                }
            }
        }
        return islandSet.size();
    }
    public void dfs(int baseRow, int baseCol, int row, int col, StringBuilder shape, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }

        int rowDiff = baseRow - row;
        int colDiff = baseCol - col;

        grid[row][col] = 0;

        shape.append("(").append(rowDiff).append(",").append(colDiff).append(")");

        dfs(baseRow, baseCol, row+1, col, shape, grid);
        dfs(baseRow, baseCol, row-1, col, shape, grid);
        dfs(baseRow, baseCol, row, col+1, shape, grid);
        dfs(baseRow, baseCol, row, col-1, shape, grid);        
    }
}