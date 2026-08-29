class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }

        while(low <= high){
            int mid_k = low + (high-low) / 2;
            
            int totalHours_at_k = timeAtKSpeed(mid_k, piles);

            if(totalHours_at_k <= h){
                high = mid_k - 1;
            }
            else{
                low = mid_k + 1;
            }
        }
        return low;
    }
    public int timeAtKSpeed(int k, int[] piles){
        int totalTime = 0;
        for(int pile : piles){
            totalTime += Math.ceil((double) pile/k);
        }

        return totalTime; 
    }
}