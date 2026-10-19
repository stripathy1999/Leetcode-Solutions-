class Solution {
    String[] mapKeys = {"0", "1","abc","def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        if(digits.length()==0) return result;

        backtrack(result, current, digits, 0);

        return result;
    }
    public void backtrack(List<String> result, StringBuilder current, String digits, int index){
        if(current.length() == digits.length()){
            result.add(current.toString());
            return;
        }

        String str = mapKeys[digits.charAt(index)-'0'];
        for(int i = 0; i<str.length(); i++){
            current.append(str.charAt(i));
            backtrack(result, current, digits, index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}