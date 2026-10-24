class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isWordEnd;

        public TrieNode(){
            children = new TrieNode[26];
            isWordEnd = false;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode current = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isWordEnd = true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];

        StringBuilder sb = new StringBuilder();

        for(String word : words){
            trie.insert(word);
        }

        
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                 dfs(row, col, trie.root, sb, visited, board, result);
            }
        }
        return result;
    }
    public void dfs(int row, int col, TrieNode current, StringBuilder sb, boolean[][] visited, char[][] board, List<String> result){
        if(row<0 || row>= board.length || col<0 || col>=board[0].length){
            return;
        }
        if(visited[row][col] == true){
            return;
        }
       
        char ch = board[row][col];
        int index = ch - 'a';
        
        if(current.children[index] == null){
            return;
        }
        
        visited[row][col] = true;
        current = current.children[index];
        sb.append(ch);

        dfs(row+1, col, current, sb, visited, board, result);
        dfs(row-1, col, current, sb, visited, board, result);
        dfs(row, col+1, current, sb, visited, board, result);
        dfs(row, col-1, current, sb, visited, board, result);
        
        if(current.isWordEnd == true){
            result.add(sb.toString());
            current.isWordEnd = false;
        }

        visited[row][col] = false;
        sb.deleteCharAt(sb.length()-1);

    }
}