class Solution {
     //s can be enpty - return an empty list
     //s should be greater than equal to p 
     //s can contain duplivcate characters
     //p is empty - return empty list
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length() || p.length() == 0){
            return result;
        }
        
        int[] PcharCount = new int[26];
        int[] windowCharCount = new int[26];

        for(char c : p.toCharArray()){
            PcharCount[c-'a']++;
        }

        int i = 0;
        int j = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            windowCharCount[c-'a']++;

            if(j-i+1 > p.length()){
                char ch = s.charAt(i);
                windowCharCount[ch-'a']--;
                i++;
            }

            if(j-i+1 == p.length()){
                if(Arrays.equals(PcharCount, windowCharCount)){
                    result.add(i);
                }
            }
            
            j++;
        }
        return result;
    }
}