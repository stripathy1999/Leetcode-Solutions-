class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1.0);
            }
        }

        return dfs(row, column, k, n, dp);
    }
    public double dfs(int row, int col, int moves, int n, double[][][] dp){
        if(row<0 || row>=n || col<0 || col>=n){
            return 0.0;
        }
        if(moves == 0){
            return 1.0;
        }
        if(dp[row][col][moves] != -1.0){
            return dp[row][col][moves];
        }

        int[][] directions = new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};

        double probability = 0.0;

        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            probability += dfs(newRow, newCol, moves-1, n, dp)/8.0;
        }

        dp[row][col][moves] = probability;

        return dp[row][col][moves];
    }
}