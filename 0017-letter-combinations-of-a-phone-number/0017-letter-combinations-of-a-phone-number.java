class Solution {
    String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(digits.length());
        if(digits == null ||digits.length()==0){
            return result;
        }

        dfs(digits, 0, result, sb);
        return result;
    }
    public void dfs(String digits, int index, List<String> result, StringBuilder sb){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for(char ch : letters.toCharArray()){
            sb.append(ch);
            dfs(digits, index+1, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}