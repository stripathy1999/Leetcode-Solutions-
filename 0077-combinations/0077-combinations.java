class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(n, k, current, result, 1);

        return result;
    }

    public void dfs(int n, int k, List<Integer> current, List<List<Integer>> result, int start){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        if((k-current.size()) > (n-start+1)){
            return;
        }

        for(int i=start; i<=n; i++){
            current.add(i);
            dfs(n, k, current, result, i+1);
            current.remove(current.size()-1);
        }
    }
}