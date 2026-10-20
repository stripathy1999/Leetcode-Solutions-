class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(n==0){
            return result;
        }

        dfs(n, result, 0, 0, sb);

        return result;
    }
    public void dfs(int n, List<String> result, int open, int close, StringBuilder sb){
        if(sb.length() == 2*n){
            result.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            dfs(n, result, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(')');
            dfs(n, result, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}