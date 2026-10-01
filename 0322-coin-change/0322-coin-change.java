class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for(int coin : coins){
            for(int i=1; i<dp.length; i++){
                if(coin <= i){
                    int remaining = i - coin;
                    dp[i] = Math.min(dp[remaining]+1, dp[i]);
                }
            }
        }

        if(dp[amount] == amount+1){
            return -1;
        }

        return dp[amount];
    }
}