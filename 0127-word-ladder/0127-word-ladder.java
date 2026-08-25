class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        queue.add(beginWord);
        visited.add(beginWord);

        int path = 1;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();

                for(int j=0; j<wordChars.length; j++){
                    char originalChar = wordChars[j];

                    for(char c='a'; c<='z'; c++){
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        if(newWord.equals(endWord)) return path+1;

                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            path++;
        }
        return 0;
    }
}