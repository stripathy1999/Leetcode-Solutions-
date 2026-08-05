class Solution {
    public void solve(char[][] board) {
        for(int col = 0; col<board[0].length; col++){
            if(board[0][col] == 'O'){
                dfs(0, col, board);
            }
            if(board[board.length-1][col] == 'O'){
                dfs(board.length-1, col, board);
            }
        }

        for(int row = 0; row<board.length; row++){
            if(board[row][0] == 'O'){
                dfs(row, 0, board);
            }
            if(board[row][board[0].length-1] == 'O'){
                dfs(row, board[0].length-1, board);
            }
        }

        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col]=='O'){
                    board[row][col] = 'X';
                }
                else if(board[row][col] == 'T'){
                    board[row][col] = 'O';
                }
            }
        }
        return;
    }

    int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    
    public void dfs(int row, int col, char[][] board){
        board[row][col] = 'T';

        for(int[] direction : directions){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow<0 || nextRow>=board.length || nextCol<0 || nextCol>=board[0].length){
                continue;
            }

            if(board[nextRow][nextCol] == 'O'){
                dfs(nextRow, nextCol, board);
            }
        }
    }
}