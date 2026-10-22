class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, result, current); //we dont have a start index because if we do everything will look to the right 

        return result;
    }
    public void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(visited[i] == true){
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            dfs(nums, visited, result, current);

            current.remove(current.size()-1);
            visited[i] = false;
        }
    }
}