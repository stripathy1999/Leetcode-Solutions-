class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int char_pointer = 0;
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
        if(pointer == word.length()){
            return true;
        }
        if(row<0 || row >= board.length || col<0 || col >= board[0].length){
            return false;
        }
        if(visited[row][col] == true){
            return false;
        }
        if(word.charAt(pointer) != board[row][col]){
            return false;
        }

        visited[row][col] = true;

        boolean found  = dfs(row+1, col, pointer+1, visited, board, word) || dfs(row-1, col, pointer+1, visited, board, word) || dfs(row, col+1, pointer+1, visited, board, word) || dfs(row, col-1, pointer+1, visited, board, word);

        visited[row][col] = false;
        
        return found;

    }
}