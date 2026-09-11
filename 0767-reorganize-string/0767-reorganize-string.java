class Solution {
    class Pair{
        char character;
        int count;

        public Pair(char character, int count){
            this.character = character;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        int[] freqMap = new int[26];
        for(char ch : s.toCharArray()){
            freqMap[ch-'a']++ ;
        }

        int maxFreq = 0;
        for(int count : freqMap){
            maxFreq = Math.max(maxFreq, count);
        }

        if((s.length() - maxFreq) < (maxFreq - 1)){
            return "";
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        for(int i = 0; i < 26; i++){
            if(freqMap[i] > 0){
                maxHeap.add(new Pair((char)(i + 'a'), freqMap[i]));
            }
        }

        StringBuilder result = new StringBuilder(s.length());
        Pair prev = null;

        while(!maxHeap.isEmpty()){
            Pair top = maxHeap.poll();
            char ch = top.character;

            result.append(ch);
            top.count--;

            if(prev!=null && prev.count > 0){
                maxHeap.add(prev);
            }

            prev = top;
        }

        return result.toString();
    }
}