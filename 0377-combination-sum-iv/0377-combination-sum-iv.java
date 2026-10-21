class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        
        return dfs(nums, 0, target, dp);
        
    }
    public int dfs(int[] nums, int currentSum, int target, int[] dp){
        if(currentSum == target){
            return 1;
        }
        if(currentSum > target){
            return 0;
        }
        if(dp[currentSum] != -1){
            return dp[currentSum];
        }
        
        int count = 0;
        for(int num : nums){
            
            count += dfs(nums, currentSum + num, target, dp);
        }

        dp[currentSum] = count;

        return count;
    }
}