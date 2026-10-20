class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(k, n, 1, 0, current, result);

        return result;
    }

    public void dfs(int k, int n, int start, int currentSum, List<Integer> current, List<List<Integer>> result){
        if(currentSum == n && current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(k-current.size() > 9-start+1){
            return;
        }
        if(currentSum > n){
            return;
        }

        for(int i=start; i<=9; i++){
            current.add(i);
            dfs(k, n, i+1, currentSum + i, current, result);
            current.remove(current.size()-1);
        }
    }
}