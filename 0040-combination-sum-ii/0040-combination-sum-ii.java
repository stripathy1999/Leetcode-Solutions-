class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(candidates, target, 0, 0, current, result);

        return result;
    }
    public void dfs(int[] candidates, int target, int start, int currentSum, List<Integer> current, List<List<Integer>> result){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(currentSum > target){
            return;
        }

        for(int i=start; i<candidates.length; i++){

            if(i != start && candidates[i] == candidates[i-1]){
                 continue;
            }
            current.add(candidates[i]);
            dfs(candidates, target, i+1, currentSum + candidates[i], current, result);
            current.remove(current.size()-1);
        }
    }
}