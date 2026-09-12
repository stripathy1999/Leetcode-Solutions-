class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1.0);
            }
        }
        
        return dfs(row, column, n, k, dp);
    }
    public double dfs(int row, int col, int n, int k, double[][][] dp){
        if(row<0 || row>=n || col<0 || col>=n){
            return 0.0;
        }
        if(k == 0){
            return 1.0;
        }
        if(dp[row][col][k] != -1.0){
            return dp[row][col][k];
        }

        int[][] directions = new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        double probability = 0.0;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            probability += dfs(newRow, newCol, n, k-1, dp)/8.0;

        }
        dp[row][col][k] = probability;

        return probability;
    }
}