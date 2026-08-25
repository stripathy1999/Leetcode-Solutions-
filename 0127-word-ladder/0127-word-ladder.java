class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordListSet= new HashSet<>(wordList);

        if(!wordListSet.contains(endWord)) return 0;
        
        queue.add(beginWord);
        visited.add(beginWord);
        int path = 1;

        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i=0; i<level; i++){
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();
                for(int j=0; j<wordChars.length; j++){
                    char originalChar = wordChars[j];
                    for(char c='a'; c<='z'; c++){
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if(newWord.equals(endWord)){
                            return path+1;
                        }
                        if(wordListSet.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            queue.add(newWord);
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