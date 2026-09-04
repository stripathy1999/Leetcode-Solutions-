class Solution {
    public boolean exist(char[][] board, String word) {
        int char_pointer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(i, j, char_pointer, visited, board, word) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int row, int col, int pointer, boolean[][] visited, char[][] board, String word){
        if(row<0 || row >= board.length || col<0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(pointer)){
            return false;
        }
        if(visited[row][col] == true){
            return false;
        }
        if(pointer == word.length()-1){
            return true;
        }
        
        visited[row][col] = true;

        boolean found = dfs(row, col+1, pointer+1, visited, board, word) || dfs(row, col-1, pointer+1, visited, board, word) || dfs(row+1, col, pointer+1, visited, board, word) || dfs(row-1, col, pointer+1, visited, board, word);

        visited[row][col] = false;

        return found;
    }
}