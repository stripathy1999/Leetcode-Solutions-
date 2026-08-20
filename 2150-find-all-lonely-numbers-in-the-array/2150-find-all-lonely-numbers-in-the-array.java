class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num: nums){
            int nextNum = num+1;
            int prevNum = num-1;

            if(map.get(num) == 1 && !map.containsKey(nextNum) && !map.containsKey(prevNum)){
                result.add(num);
            }
        }
        return result;
    }
}