class NumArray {

    int[] nums;
    int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length+1];
        int sum = 0;
        prefixSum[0] = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            prefixSum[i+1] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right+1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */