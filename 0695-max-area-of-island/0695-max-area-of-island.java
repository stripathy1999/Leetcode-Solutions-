class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<grid[0].length; j++){
                int area = 0;
                if(grid[i][j] == 1){
                    area = dfs(i, j, area, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int area, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return area;
        }

        grid[i][j] = 0;
        area += 1;
        area = dfs(i+1, j, area, grid);
        area = dfs(i-1, j, area, grid);
        area = dfs(i, j+1, area, grid);
        area = dfs(i, j-1, area, grid);

        return area;

    }
}