class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                int area = 0;
                if(grid[i][j] == 1){
                    area = dfs(i, j, grid, area);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int[][] grid, int area){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return area;
        }

        grid[i][j] = 0;
        area += 1;
        area = dfs(i+1, j, grid, area);
        area = dfs(i-1, j, grid, area);
        area = dfs(i, j+1, grid, area);
        area = dfs(i, j-1, grid, area);

        return area;
    }
}