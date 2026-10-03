class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length+1];
        dp[0][0] = 1;

        for(int coin = 0; coin<=coins.length ; coin++){
            dp[0][coin] = 1;
        }

        for(int coin = 1; coin<=coins.length; coin++){
            int currentCoin = coins[coin-1];

            for(int amt = 1; amt <= amount; amt++){
                
                //skip the coin
                dp[amt][coin] = dp[amt][coin-1];

                //take the coin
                if(currentCoin <= amt){
                    dp[amt][coin] += dp[amt-currentCoin][coin];
                }
            }
        }
        return dp[amount][coins.length];
    }
}
