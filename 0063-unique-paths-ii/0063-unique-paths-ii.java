class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, m-1, n-1, dp, obstacleGrid);
    }
    public int dfs(int row, int col, int m, int n, int[][] dp, int[][] obstacleGrid){
        if(row<0 || row>=m+1 || col<0 || col>=n+1){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == m && col == n){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int rightPath = dfs(row, col+1, m, n, dp, obstacleGrid);
        int downPath = dfs(row+1, col, m, n, dp, obstacleGrid);

        dp[row][col] = rightPath + downPath;

        return dp[row][col];
    }
}