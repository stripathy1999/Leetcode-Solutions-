class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        dfs(candidates, 0, current, 0, result, target);
        
        return result;
    }
    public void dfs(int[] candidates, int start, List<Integer> current, int currentSum, List<List<Integer>> result, int target){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(currentSum > target){
            return;
        }

        for(int i=start; i<candidates.length; i++){
            current.add(candidates[i]);
            dfs(candidates, i, current, currentSum + candidates[i], result, target);
            current.remove(current.size()-1);
        }
    }
}