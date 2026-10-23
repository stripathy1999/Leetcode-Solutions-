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
    public boolean dfs(String word, int wordIndex, TrieNode current){
        if(wordIndex == word.length()){
            return current.isWordEnd;
        }

        char ch = word.charAt(wordIndex);
        
        if(ch == '.'){
            for(TrieNode child : current.children){
                if(child==null){
                    continue;
                }
                if(dfs(word, wordIndex+1, child) == true){
                    return true;
                }
            }
            return false;
        }

        int childIndexInTrie = ch - 'a';
        if(current.children[childIndexInTrie] == null){
            return false;
        }
        return dfs(word, wordIndex+1, current.children[childIndexInTrie]);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */