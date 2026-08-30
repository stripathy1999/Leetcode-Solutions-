class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, m-1, n-1, dp);
   }
   public int dfs(int row, int col, int m, int n, int[][] dp){
        if(row>=m+1 || col>=n+1 || row<0 || col<0){
            return 0;
        }
        if(row == m && col == n){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int rightPath = dfs(row, col+1, m, n, dp);
        int downPath = dfs(row+1, col, m, n, dp);

        dp[row][col] = rightPath + downPath;
        return dp[row][col];
   }
}