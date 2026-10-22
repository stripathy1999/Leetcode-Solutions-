class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        return dfs(n, 0, board, columnSet, diagonal1, diagonal2);
    }
    public int dfs(int n, int row, char[][] board, Set<Integer> columnSet, Set<Integer> diagonal1, Set<Integer> diagonal2){
        if(row == n){
            return 1;
        }

        int count = 0;
        for(int col = 0; col<n; col++){
            if(columnSet.contains(col) || diagonal1.contains(row-col) || diagonal2.contains(row+col)){
                continue;
            }

            columnSet.add(col);
            diagonal1.add(row-col);
            diagonal2.add(row+col);

            count += dfs(n, row+1, board, columnSet, diagonal1, diagonal2);

            columnSet.remove(col);
            diagonal1.remove(row-col);
            diagonal2.remove(row+col);
        }

        return count;
    }
}