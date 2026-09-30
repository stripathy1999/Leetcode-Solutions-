class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            int j= i+1;
            int k= nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    k--;
                }

                int currentDiff = Math.abs(sum - target);
                if(currentDiff < minDiff){
                    closestSum = sum;
                    minDiff = currentDiff;
                }
            }
        }
        return closestSum;
    }
}