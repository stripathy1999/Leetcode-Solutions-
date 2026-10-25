class Solution {
    public int characterReplacement(String s, int k) {
        int i=0; 
        int j=0;

        int[] freqMap = new int[26];
        int maxLength = 0;

        int charMaxFrequency = 0;

        while(i<=j && j<s.length()){
            char ch = s.charAt(j);
            freqMap[ch-'A']++;//here we add the character j in the window

            charMaxFrequency = Math.max(charMaxFrequency, freqMap[ch-'A']);
            
            int windowLength = j-i+1;
            int replacementNeeded = windowLength - charMaxFrequency;

            if(replacementNeeded <= k){
                maxLength = Math.max(windowLength, maxLength);
                j++;
            }
            else{
                char c = s.charAt(i);
                freqMap[c -'A']--;
                i++;
                j++; //move j because character j has already been added in the window, and we dont want to count it again when we decrease window 
            }
        }
        return maxLength;
    }
}