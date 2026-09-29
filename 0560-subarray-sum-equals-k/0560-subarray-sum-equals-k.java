class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int complement = sum - k;
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}