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

    
    public void dfs(int row, int col, char[][] board){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] != 'O' || board[row][col] == 'X'){
            return;
        }
        board[row][col] = 'T';

        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}