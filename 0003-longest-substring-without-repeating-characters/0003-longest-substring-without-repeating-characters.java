class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i= 0;
        int j = 0;
        int maxLength = 0;

        while(i<=j && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                int windowLength = j-i+1;
                maxLength = Math.max(maxLength, windowLength);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}