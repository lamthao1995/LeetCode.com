public class Solution {
    public void nextPermutation(int[] nums) {
        int cur = nums.length - 2;
        while(cur >= 0 && nums[cur + 1] <= nums[cur]){
            cur--;
        }
        if(cur >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[cur]){
                j--;
            }
            swap(nums, cur, j);
        }
        reverse(nums, cur + 1);
    }
     private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}