class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(s==null || s.length() == 0){
            return result;
        }

        dfs(s, 0, result, sb);
        return result;
    }
    public void dfs(String s, int index, List<String> result, StringBuilder sb){
        if(sb.length() == s.length()){
            result.add(sb.toString());
            return;
        }

        char ch = s.charAt(index);
        if(ch>='A'&& ch<='Z'){
            sb.append(Character.toLowerCase(ch));
            dfs(s, index+1, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(ch>='a' && ch<='z'){
            sb.append(Character.toUpperCase(ch));
            dfs(s, index+1, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append(ch);
        dfs(s, index+1, result, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}