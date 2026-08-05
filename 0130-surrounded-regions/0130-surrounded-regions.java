class Solution {
    public void solve(char[][] board) {
        for(int col = 0; col<board[0].length; col++){
            //Traverse from borders directly and turn all O's to T's because border O's cant be surrounded and captured. 
            //Start from two ends of the column
            if(board[0][col] == 'O'){
                dfs(0, col, board);
            }
            if(board[board.length-1][col] == 'O'){
                dfs(board.length-1, col, board);
            }
        }
        //Travser and start from two ends of the row and use dfs to those border O's to T's and any connected O cells to T as they cant be captured
        for(int row = 0; row<board.length; row++){
            if(board[row][0] == 'O'){
                dfs(row, 0, board);
            }
            if(board[row][board[0].length-1] == 'O'){
                dfs(row, board[0].length-1, board);
            }
        }

        //After all the updates, switch all the T's back to O's and all the O's inside any other cells apart from borders to X's
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