class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(nums, result, current); //we dont have a start index because if we do everything will look to the right 

        return result;
    }
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(current.contains(nums[i])){
                continue;
            }

            current.add(nums[i]);
            dfs(nums, result, current);
            current.remove(current.size()-1);
    
        }
    }
}