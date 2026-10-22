class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0  && nums[i] >= nums[i+1]){
            i--;
        }
        
        int pivot = i;

        if(pivot >= 0){
            int j = nums.length-1;
            while(j>0 && nums[j] <= nums[pivot]){
                j--;
            }

            swap(nums, pivot, j);
        }
        reverse(nums, i+1, nums.length-1);
    }
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}