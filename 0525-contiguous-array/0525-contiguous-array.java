class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            prefixSum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(prefixSum)){
                int length = i - map.get(prefixSum);
                maxLength = Math.max(length, maxLength);
            }
            else{
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}