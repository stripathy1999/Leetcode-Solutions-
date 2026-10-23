class TrieNode{
    TrieNode[] children;
    boolean isWordEnd;

    int prefixCount;
    int wordCount;

    public TrieNode(){
        children = new TrieNode[26];
        isWordEnd = false;
        prefixCount = 0;
        wordCount = 0;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(char ch: word.toCharArray()){

            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.prefixCount += 1;
        }
        current.isWordEnd = true;
        current.wordCount += 1;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode current = root;
        
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            
            if(current.children[index] == null){
                return 0;
            }
            current = current.children[index];
        }
        return current.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()){

            int index = ch - 'a';
            if(current.children[index] == null){
                return 0;
            }
            current = current.children[index];
        }
        return current.prefixCount;
    }
    
    public void erase(String word) {
        TrieNode current = root;

        for(char ch: word.toCharArray()){

            int index = ch - 'a';
            if(current.children[index] == null){
                return;
            }
            current = current.children[index];
            current.prefixCount -= 1;
        }
        current.isWordEnd = false;;
        current.wordCount -= 1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */