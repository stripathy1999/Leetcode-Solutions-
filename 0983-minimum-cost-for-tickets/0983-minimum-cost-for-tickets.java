class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        boolean[] travelDays = new boolean[lastDay+1];

        for(int day: days){
            travelDays[day] = true;
        }

        int[] dp = new int[lastDay+1];
        dp[0] = 0;

        for(int i=1; i<dp.length; i++){

            if(travelDays[i] == false){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)]+ costs[1], dp[Math.max(0, i-30)] + costs[2]));
        }

        return dp[lastDay];
    }
}