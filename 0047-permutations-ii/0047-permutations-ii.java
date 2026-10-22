class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length+1];
        
        dfs(nums, visited, current, result);

        return result;
    }
    public void dfs(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i] == true){
                continue;
            }
            if( i>0 && nums[i] == nums[i-1] && visited[i-1] == false){
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            dfs(nums, visited, current, result);

            current.remove(current.size()-1);
            visited[i] = false;
        }
    }
}