class TrieNode{
    TrieNode[] children;
    boolean isWordEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isWordEnd = false;
    }
}
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, TrieNode current){
        if(index == word.length()){
            return current.isWordEnd;
        }

        char ch = word.charAt(index);

        if(ch == '.'){
            for(TrieNode child : current.children){
                if(child == null){
                    continue;
                }
                if(dfs(word, index+1, child) == true){
                    return true;
                }
            }
            return false;
        }
        
        int childIndex = ch - 'a';
        if(current.children[childIndex] == null){
            return false;
        }
        return dfs(word, index+1, current.children[childIndex]);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */