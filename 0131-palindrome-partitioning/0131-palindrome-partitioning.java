class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        dfs(s, 0, current, result);

        return result;
    }
    public void dfs(String s, int start, List<String> current, List<List<String>> result){
        if(start == s.length()){ //that means the string is explored and partitioned, and we can add the current string with partition pieces to result
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<s.length(); i++){
            String piece = s.substring(start, i+1);
            if(isPalindrome(piece) == true){
                current.add(piece);
                dfs(s, i+1, current, result);
                current.remove(current.size()-1);
            }
        } 
    }
    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        while(low<=high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}