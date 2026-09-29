class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int i: nums){
            if(map.get(i) > (nums.length / 2)){
                return i;
            }
        }
        return 0;
    }
}

/*class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int n : nums){
            if(count==0){
                candidate = n;
            }

            if(candidate == n){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
}*/