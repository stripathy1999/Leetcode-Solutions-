class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums==null || nums.length == 0){
            return result;
        }

        List<Integer> current = new ArrayList<>();

        dfs(nums, result, current, 0);

        return result;
    }
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> current, int start){
        result.add(new ArrayList<>(current));

        for(int i=start; i<nums.length; i++){
            current.add(nums[i]);

            dfs(nums, result, current, i+1);

            current.remove(current.size()-1);
        }
    }
}