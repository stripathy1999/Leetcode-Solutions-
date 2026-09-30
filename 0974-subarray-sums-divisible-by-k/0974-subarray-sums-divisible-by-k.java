class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningPrefixSum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i: nums){
            runningPrefixSum += i;
            int remainder = ((runningPrefixSum % k)+k) % k;
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}