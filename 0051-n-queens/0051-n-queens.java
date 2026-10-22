class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int row=0; row<n; row++){
            Arrays.fill(board[row], '.');
        }

        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        dfs(n, 0, columnSet, diagonal1, diagonal2, result, board);

        return result;
    }
    public void dfs(int n, int row, Set<Integer> columnSet, Set<Integer> diagonal1, Set<Integer> diagonal2, List<List<String>> result, char[][] board){
        if(row == n){
            List<String> currentBoard = new ArrayList<>();

            for(char[] boardRow : board){
                currentBoard.add(new String(boardRow));
            }

            result.add(currentBoard);
        }

        for(int col=0; col<n; col++){
            if(columnSet.contains(col)) continue;
            if(diagonal1.contains(row-col)) continue;
            if(diagonal2.contains(row+col)) continue;

            board[row][col] = 'Q';

            columnSet.add(col);
            diagonal1.add(row-col);
            diagonal2.add(row+col);

            dfs(n, row+1, columnSet, diagonal1, diagonal2, result, board);

            board[row][col] = '.';

            columnSet.remove(col);
            diagonal1.remove(row-col);
            diagonal2.remove(row+col);
        }
    }
}