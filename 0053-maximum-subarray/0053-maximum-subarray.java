class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0; //this is the maximum sum of a subarray ending at the current index
        for(int n : nums){
            if(currSum+n > n){ //if I extend current subarray (currSum + n), is it better than if I start a new subarray from the current element (n).
                currSum = currSum+n; //I would want to keep the currSum that is better, if I am extending it and getting better, then Ill keep it 
            }
            else{
                currSum = n; //If Im starting a new subarray and the currSum at that index is better than extending it, then Ill keep the currSum of new subarray.
            }

            maxSum = Math.max(currSum, maxSum); //this is the maximum sum seen all across the subarrays. 
        }
        return maxSum;
    }
}