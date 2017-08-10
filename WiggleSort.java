public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if((i % 2 == 0) == (nums[i] > nums[i + 1])){
                swap(i, i + 1, nums);
            }
        }
    }
    public void swap(int i, int j, int nums[]){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}