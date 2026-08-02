class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                int fish = 0;
                if(grid[r][c] != 0){
                    fish = dfs(r, c, fish, grid);
                    maxFish = Math.max(fish, maxFish);
                }
            }
        }
        return maxFish;
    }
    public int dfs(int r, int c, int fishes, int[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0){
            return fishes;
        }

        fishes += grid[r][c];
        grid[r][c] = 0;
        fishes = dfs(r+1, c, fishes, grid);
        fishes = dfs(r-1, c, fishes, grid);
        fishes = dfs(r, c+1, fishes, grid);
        fishes = dfs(r, c-1, fishes, grid);

        return fishes;
    }
}